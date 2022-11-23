package com.pokemon.domain;

import javax.persistence.*;

@Entity
public class Auction
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    private Card card;
    @ManyToOne
    private PokemonCollector pokemonCollector;
    private double price;
    private int cardAmount;

    private Auction()
    {
    }

    public Auction(int cardAmount, double price, Card card, PokemonCollector pokemonCollector)
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

    public Card getCard()
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
