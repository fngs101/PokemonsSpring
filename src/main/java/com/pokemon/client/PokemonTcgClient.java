package com.pokemon.client;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonTcgClient
{
    private CardRepository repository;
    private static final String URL = "https://api.pokemontcg.io/v2/cards/";

    public PokemonTcgClient(CardRepository repository)
    {
        this.repository = repository;
    }

    @PostConstruct
    public void downloadCards()
    {
        if(repository.count() != 0)
        {
            return;
        }
        RestTemplate restTemplate = new RestTemplate();
        List<Card> cardsList = restTemplate.getForObject(URL, PokemonRequest.class).getData()
                .stream()
                .map(cardRequest -> new Card(cardRequest.getName(), cardRequest.getImages().getSmall()))
                .collect(Collectors.toList());
        System.out.println(cardsList);

        repository.saveAll(cardsList);

    }
}
