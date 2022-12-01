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


        for(int i = 1; i <= 2; i++)
        {
            int iCopy = i;

            Runnable runnable = () ->
            {
                List<Card> cardsList = restTemplate.getForObject(URL + "?page=" + iCopy + "&pageSize=" + pageSize, PokemonRequest.class).getData()
                        .stream()
                        .map(cardRequest -> new Card(cardRequest.getId(), cardRequest.getName(), cardRequest.getImages().getSmall()))
                        .collect(Collectors.toList());
                System.out.println("Finished download for page " + iCopy);

                cardRepository.saveAll(cardsList);
            };
            Thread thread = new Thread(runnable);
            thread.start();

        }



    }
}
