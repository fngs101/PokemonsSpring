package com.pokemon.domain;

import com.pokemon.client.ImagesRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card
{
    @Id
    private String name;

    private String url;

    public Card(String name, String url)
    {
        this.name = name;
        this.url = url;
    }

    private Card()
    {

    }

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

}
