package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account
{
    @Id
    private String email;
    private String password;
    @OneToOne
    private PokemonCollector pokemonCollector;

    public Account(String email, String password, PokemonCollector pokemonCollector)
    {
        this.email = email;
        this.password = password;
        this.pokemonCollector = pokemonCollector;
    }

    Account()
    {

    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public PokemonCollector getPokemonCollector()
    {
        return pokemonCollector;
    }
}
