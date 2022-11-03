package com.pokemon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OwnedCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    //nie podoba mi sie ze istnieje tabela ownedcard taka w powietrzu, powinna byc powiazana z pokemoncollectorem wiec zrobilam ponizsze
    //ale skad sie bierze tabela POKEMON_COLLECTOR_OWNED_CARD_LIST
   // @ManyToOne
    /*@JoinColumns({
            @JoinColumn(name="POKEMONCOLLECTOR_ID", referencedColumnName="id")
    })*/
    //private PokemonCollector pokemonCollector;
    @ManyToOne
  //  @JoinColumn(name = "card_Name", referencedColumnName = "name")
    private Card card;
    private int amount;

    public OwnedCard()
    {
    }

    public OwnedCard( Card card, int amount)
    {
       // this.pokemonCollector = pokemonCollector;
        this.card = card;
        this.amount = amount;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Card getCard()
    {
        return card;
    }

    public void setCard(Card card)
    {
        this.card = card;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

   /* public PokemonCollector getPokemonCollector()
    {
        return pokemonCollector;
    }

    public void setPokemonCollector(PokemonCollector pokemonCollector)
    {
        this.pokemonCollector = pokemonCollector;
    }*/
}
