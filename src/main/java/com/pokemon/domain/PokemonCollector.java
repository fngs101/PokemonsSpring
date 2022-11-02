package com.pokemon.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PokemonCollector
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String userName;
    @OneToMany(fetch=FetchType.EAGER)
    private List<OwnedCard> ownedCardList = new ArrayList<>();
    private int pokemonCoin = 10000;


    public PokemonCollector()
    {

    }
    public void addCards2(List<OwnedCard> boughtCards)
    {
        ownedCardList.addAll(boughtCards);
    }

//    public void addCards(List<Card> boughtCards)
//    {
//        cardList.addAll(boughtCards);
//    }
//
//    public List<Card> getCardList()
//    {
//        return cardList;
//    }

    public List<OwnedCard> getOwnedCardList()
    {
        return ownedCardList;
    }

    public int getPokemonCoin()
    {
        return pokemonCoin;
    }

    public void subtractPokemonCoin(int coinsToSubtract)
    {
        pokemonCoin -= coinsToSubtract;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setOwnedCardList(List<OwnedCard> ownedCardList)
    {
        this.ownedCardList = ownedCardList;
    }

    public void setPokemonCoin(int pokemonCoin)
    {
        this.pokemonCoin = pokemonCoin;
    }
}
