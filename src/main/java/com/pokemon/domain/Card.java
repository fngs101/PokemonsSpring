package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Card
{
    @Id
    private String name;

    public Card(String name)
    {
        this.name = name;
    }

    private Card()
    {

    }

    public String getName()
    {
        return name;
    }
}
