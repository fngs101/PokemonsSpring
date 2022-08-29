package com.pokemon.client;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
        //z załozenia będzie sciagac je przez API, teraz na razie new cards które wrzucam do bazy
        List<Card> pokemonCards = new ArrayList<>();
        for(int i = 1; i < 11; i++)
        {
            Card pokemonCard = new Card("pokemon" + i);
            pokemonCards.add(pokemonCard);
        }
        repository.saveAll(pokemonCards);
        System.out.println(repository.count());
        //przy kolejnym run nie było errorów, w logu najpierw robił select, i nie zrobił w ogóle create
    }
}
