package com.pokemon.client;

import com.pokemon.domain.Card;

import java.util.List;

public class PokemonRequest
{
    private List<CardRequest> data;

    public List<CardRequest> getData()
    {
        return data;
    }
}
