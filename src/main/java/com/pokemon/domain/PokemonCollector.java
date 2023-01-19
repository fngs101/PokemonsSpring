package com.pokemon.domain;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.hibernate.annotations.Cascade;

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
    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pokemonCollector")
    private List<OwnedCard> ownedCardList = new ArrayList<>();
    private int pokemonCoin = 10000;


    public PokemonCollector()
    {

    }

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

    public void addCards(List<Card> randomCards)
    {
        for(Card card : randomCards)
        {
            OwnedCard duplicateCard = findDuplicate(card.getName());
            if(duplicateCard == null)
            {
                OwnedCard ownedCard = new OwnedCard( card, 1);
                ownedCard.setPokemonCollector(this);
                ownedCardList.add(ownedCard);
            }
            else
            {
                duplicateCard.setAmount(duplicateCard.getAmount() + 1);
            }

        }
    }

    private OwnedCard findDuplicate(String cardName)
    {
        for(OwnedCard ownedCard : ownedCardList)
        {
            if(ownedCard.getCard().getName().equals(cardName))
            {
                return ownedCard;
            }
        }
        return null;
    }
}
