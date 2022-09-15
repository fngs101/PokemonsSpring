package com.pokemon.service;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ShopService
{
    private CardRepository cardRepository;

    public ShopService(CardRepository cardRepository)
    {
        this.cardRepository = cardRepository;
    }

    public List<Card> buy()
    {
        List<Card> allCards = cardRepository.findAll();

        Collections.shuffle(allCards);
        List<Card> randomCards = allCards.subList(0, 5);

        return randomCards;
    }
}
