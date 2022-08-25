package com.pokemon.service;

import com.pokemon.domain.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService
{
    public List<Card> buy()
    {
        //wyciagac je z bazy danych zamiast ego nizej
        //klasa klienta 10 kart
        //tutaj losowanie tych kart np. 5
        //metoda count z repository zeby sprawdzic ile jest w bazie danych kart zeby nie było error

        return List.of(new Card("Pokemon1"), new Card("Pokemon2"), new Card("Pokemon3"));
    }
}
