package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class PokemonCollector
{
    @Id
    private int id;
    private String userName;
    private List<Card> cardList;
    private int pokemonCoin;
}
