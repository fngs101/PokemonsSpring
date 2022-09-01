package com.pokemon.client;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class CardRequest
{
    private String name;

    private ImagesRequest images;

    private CardRequest()
    {

    }
    public String getName()
    {
        return name;
    }

    public ImagesRequest getImages()
    {
        return images;
    }
}
