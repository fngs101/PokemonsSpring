package com.pokemon.service;

import com.pokemon.domain.Card;
import com.pokemon.domain.OwnedCard;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.exception.ShopServiceException;
import com.pokemon.repository.CardRepository;
import com.pokemon.repository.OwnedCardRepository;
import com.pokemon.repository.PokemonCollectorRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShopService
{
    private CardRepository cardRepository;
    private PokemonCollectorRepository pokemonCollectorRepository;
    private AuthorizationService authorizationService;
    private OwnedCardRepository ownedCardRepository;


    public ShopService(CardRepository cardRepository, PokemonCollectorRepository pokemonCollectorRepository,
                       AuthorizationService authorizationService, OwnedCardRepository ownedCardRepository)
    {
        this.cardRepository = cardRepository;
        this.pokemonCollectorRepository = pokemonCollectorRepository;
        this.authorizationService = authorizationService;
        this.ownedCardRepository = ownedCardRepository;
    }

    public List<Card> buy() throws ShopServiceException
    {
        List<Card> randomCards = drawCards();
        int fullPrice = countPriceOfCards(randomCards);

        int id = authorizationService.getPokemonCollectorId();
        PokemonCollector pokemonCollector = pokemonCollectorRepository.findById(id).get();


        if(canUserAffordBuy(fullPrice, pokemonCollector.getPokemonCoin()))
        {

            pokemonCollector.addCards(randomCards);
            ownedCardRepository.saveAll(pokemonCollector.getOwnedCardList());

            pokemonCollector.subtractPokemonCoin(fullPrice);

            pokemonCollectorRepository.save(pokemonCollector);

        }
        else
        {
            throw new ShopServiceException("No money to buy cards");
        }
        return randomCards;


    }

    private List<Card> drawCards()
    {
        List<Card> allCards = cardRepository.findAll();

        Collections.shuffle(allCards);
        List<Card> randomCards = allCards.subList(0, 5);
        return randomCards;
    }

    private int countPriceOfCards(List<Card> randomCards)
    {
        int fullPrice = randomCards.stream()
                .mapToInt(card -> card.getPrice())
                .sum();

        return fullPrice;
    }

    private OwnedCard findDuplicate(String cardName, List<OwnedCard> ownedCards)
    {
        for(OwnedCard ownedCard : ownedCards)
        {
            if(ownedCard.getCard().getName().equals(cardName))
            {
                return ownedCard;
            }
        }
        return null;
    }

    private boolean canUserAffordBuy(int fullPrice, int pokemonCoin)
    {
        return pokemonCoin >= fullPrice;
    }
}
