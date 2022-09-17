package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class PokemonCollector
{
    @Id
    private int id;
    private String userName;
    @OneToOne(targetEntity=Card.class)
    private List<Card> cardList;
    private int pokemonCoin;

    private PokemonCollector()
    {

    }
}
