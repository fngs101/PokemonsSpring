package com.pokemon.client;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class PokemonTcgClient
{
    private CardRepository cardRepository;
    private static final String URL = "https://api.pokemontcg.io/v2/cards/";
    private static final int totalCount = 15615;
    private static final int pageSize = 250;

    public PokemonTcgClient(CardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    @PostConstruct
    public void downloadCards()
    {
        if(cardRepository.count() != 0)
        {
            return;
        }
        RestTemplate restTemplate = new RestTemplate();

        int amountOfPages = totalCount / pageSize + 1;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 1; i <= amountOfPages; i++)
        {
            String url = URL + "?page=" + i + "&pageSize=" + pageSize;
            Runnable runnable = new CardDownloadTask(restTemplate, cardRepository, url);
            executorService.execute(runnable);
//            Thread thread = new Thread(runnable);
//            thread.start();
        }
        executorService.shutdown();


    }

}
