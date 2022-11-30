package com.pokemon.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OwnedCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Card card;
    private int amount;

    public OwnedCard()
    {
    }

    public OwnedCard( Card card, int amount)
    {
       // this.pokemonCollector = pokemonCollector;
        this.card = card;
        this.amount = amount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

   /* public PokemonCollector getPokemonCollector()
    {
        return pokemonCollector;
    }

    public void setPokemonCollector(PokemonCollector pokemonCollector)
    {
        this.pokemonCollector = pokemonCollector;
    }*/

    @Override
    public String toString()
    {
        return "OwnedCard{" +
                "id=" + id +
                ", card=" + card.getName() +
                ", amount=" + amount +
                '}';
    }
}
