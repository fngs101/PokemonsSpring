package com.pokemon.client;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class PokemonTcgClient
{
    private CardRepository repository;
    private static final String URL = "https://api.pokemontcg.io/v2/cards/";
    private static final int totalCount = 15615;

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

        for(int i = 0; i < 50; i++)
        {
            int iCopy = i;
            Runnable runnable = () ->
            {
                List<Card> cardsList = restTemplate.getForObject(URL + "?page=" + iCopy, PokemonRequest.class).getData()
                        .stream()
                        .map(cardRequest -> new Card(cardRequest.getName(), cardRequest.getImages().getSmall()))
                        .collect(Collectors.toList());
                System.out.println("finished download " + iCopy + " " + cardsList);


                repository.saveAll(cardsList);
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }



    }
}
