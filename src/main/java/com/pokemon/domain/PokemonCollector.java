package com.pokemon.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class PokemonCollector
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String userName;
    @OneToMany(fetch=FetchType.EAGER)
    private List<Card> cardList;
    private int pokemonCoin = 100;


    public PokemonCollector()
    {

    }

    public void addCards(List<Card> cardList)
    {
        this.cardList.addAll(cardList);
    }
}
