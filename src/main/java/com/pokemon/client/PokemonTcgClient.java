package com.pokemon.client;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class PokemonTcgClient
{
    private CardRepository repository;

    public PokemonTcgClient(CardRepository repository)
    {
        this.repository = repository;
    }

    @PostConstruct
    public void downloadCards()
    {
        List<Card> pokemonCards = List.of(new Card("Pokemon1"), new Card("Pokemon2"), new Card("Pokemon3"));
        System.out.println("sciagam karty");
        repository.saveAll(pokemonCards);
    }
}
