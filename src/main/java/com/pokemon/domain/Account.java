package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return email.equals(account.email);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(email);
    }
}
