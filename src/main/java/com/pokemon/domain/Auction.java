package com.pokemon.domain;

import javax.persistence.*;

@Entity
public class Auction
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private OwnedCard card;
    @ManyToOne
    private PokemonCollector pokemonCollector;
    private double price;
    private int cardAmount;

    private Auction()
    {
    }

    public Auction(int cardAmount, double price, OwnedCard card, PokemonCollector pokemonCollector)
    {
        this.cardAmount = cardAmount;
        this.price = price;
        this.card = card;
        this.pokemonCollector = pokemonCollector;
    }

    public int getId()
    {
        return id;
    }

    public OwnedCard getCard()
    {
        return card;
    }

    public PokemonCollector getPokemonCollector()
    {
        return pokemonCollector;
    }

    public double getPrice()
    {
        return price;
    }

    public int getCardAmount()
    {
        return cardAmount;
    }
}
