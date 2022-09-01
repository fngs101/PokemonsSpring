package com.pokemon.client;

import javax.persistence.Entity;
//rest api spring security

public class ImagesRequest
{
    private String small;
    private String large;


    public String getSmall()
    {
        return small;
    }

    public String getLarge()
    {
        return large;
    }
}
