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

    public Auction(int cardAmount, double price)
    {
        this.cardAmount = cardAmount;
        this.price = price;
    }
}
