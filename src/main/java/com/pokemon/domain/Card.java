package com.pokemon.domain;

import com.pokemon.client.ImagesRequest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Card
{
    @Id
    private String id;
    private String name;


    private String url;
    private int price = 10;

    public Card(String id, String name, String url)
    {
        this.id = id;
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

    public int getPrice()
    {
        return price;
    }

    public String getId()
    {
        return id;
    }
}
