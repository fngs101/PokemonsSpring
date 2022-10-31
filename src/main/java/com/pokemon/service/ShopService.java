package com.pokemon.service;

import com.pokemon.domain.Card;
import com.pokemon.domain.OwnedCard;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.exception.ShopServiceException;
import com.pokemon.repository.CardRepository;
import com.pokemon.repository.OwnedCardRepository;
import com.pokemon.repository.PokemonCollectorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        PokemonCollector pokemonCollector = authorizationService.getLoggedUserCollector();
        List<OwnedCard> ownedCards = pokemonCollector.getOwnedCardList();

        checkForDuplicates(randomCards, ownedCards);
        if(canUserAffordBuy(fullPrice, pokemonCollector.getPokemonCoin()))
        {

            List<OwnedCard> boughtCards = new ArrayList<>();
            for(Card card : randomCards)
            {
                OwnedCard ownedCard = new OwnedCard();
                ownedCard.setCard(card);
                ownedCard.setAmount(1);
                boughtCards.add(ownedCard);

            }
            pokemonCollector.addCards2(boughtCards);
            ownedCardRepository.saveAll(boughtCards);
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

    private void checkForDuplicates(List<Card> randomCards, List<OwnedCard> ownedCards)
    {
        boolean ee = randomCards.stream().anyMatch(card -> ownedCards.contains(card));

        System.out.println(ee);
    }

    private boolean canUserAffordBuy(int fullPrice, int pokemonCoin)
    {
        return pokemonCoin >= fullPrice;
    }
}
