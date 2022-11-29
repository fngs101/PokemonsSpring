package com.pokemon.client;


public class CardRequest
{
    private String id;
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

    public String getId()
    {
        return id;
    }
}
