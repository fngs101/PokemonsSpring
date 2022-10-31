package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class OwnedCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private Card card;
    private int amount;

    public OwnedCard()
    {
    }
}
