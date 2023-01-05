package com.pokemon.client;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class CardDownloadTask implements Runnable
{
    private RestTemplate restTemplate;
    private CardRepository cardRepository;
    private String url;
    private int tryCount;
    private static final int MAX_COUNT = 3;

    public CardDownloadTask(RestTemplate restTemplate, CardRepository cardRepository, String url)
    {
        this.restTemplate = restTemplate;
        this.cardRepository = cardRepository;
        this.url = url;
    }

    @Override
    public void run()
    {
        try
        {
            tryCount++;
            downloadAndSave();
        }
        catch(RestClientException exception)
        {
            if(tryCount != MAX_COUNT)
            {
                System.out.println("Repeating the request for: " + url);
                run();
            }
            else
            {
                System.out.println("Stopped making requests");
            }


        }


    }

    public void downloadAndSave()
    {
        List<Card> cardsList = restTemplate.getForObject(url, PokemonRequest.class).getData()
                .stream()
                .map(cardRequest -> new Card(cardRequest.getId(), cardRequest.getName(), cardRequest.getImages().getSmall()))
                .collect(Collectors.toList());
        System.out.println("Finished download for url " + url);

        cardRepository.saveAll(cardsList);
    }

}
