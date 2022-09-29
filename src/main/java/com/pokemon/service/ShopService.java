package com.pokemon.service;

import com.pokemon.domain.Card;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.repository.CardRepository;
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

    public ShopService(CardRepository cardRepository, PokemonCollectorRepository pokemonCollectorRepository,
                       AuthorizationService authorizationService)
    {
        this.cardRepository = cardRepository;
        this.pokemonCollectorRepository = pokemonCollectorRepository;
        this.authorizationService = authorizationService;
    }

    public List<Card> buy()
    {
        List<Card> allCards = cardRepository.findAll();

        Collections.shuffle(allCards);
        List<Card> randomCards = allCards.subList(0, 5);

        PokemonCollector pokemonCollector = authorizationService.getLoggedUserCollector();
        pokemonCollector.addCards(randomCards);
        pokemonCollectorRepository.save(pokemonCollector);

        return randomCards;
    }
}
