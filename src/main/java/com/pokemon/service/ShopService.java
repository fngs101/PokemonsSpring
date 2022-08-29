package com.pokemon.service;

import com.pokemon.domain.Card;
import com.pokemon.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return (List<Card>) cardRepository.findAll();
    }
}
