package com.pokemon.client;


import java.util.List;

public class PokemonRequest
{
    private List<CardRequest> data;
    private int totalCount;

    public List<CardRequest> getData()
    {
        return data;
    }

    public int getTotalCount()
    {
        return totalCount;
    }
}
