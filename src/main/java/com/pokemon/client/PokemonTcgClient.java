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

        //todo jak znalezc info ile w ogole jest obiektow, stron poprzez resttemplate. Nizej proba wyciagniecia z jsona? nie wiem
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
//        result.getBody().

        List<Card> cardsList = restTemplate.getForObject(URL, PokemonRequest.class).getData()
                .stream()
                .map(cardRequest -> new Card(cardRequest.getName(), cardRequest.getImages().getSmall()))
                .collect(Collectors.toList());
        System.out.println(cardsList);

        repository.saveAll(cardsList);

    }
}
