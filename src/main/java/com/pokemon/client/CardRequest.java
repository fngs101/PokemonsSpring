package com.pokemon.client;


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
