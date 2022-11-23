package com.pokemon.service;

import com.pokemon.domain.Auction;
import com.pokemon.domain.OwnedCard;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.exception.AuctionException;
import com.pokemon.repository.AuctionHouseRepository;
import com.pokemon.repository.PokemonCollectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionHouseService
{
    private PokemonCollectorRepository pokemonCollectorRepository;
    private AuthorizationService authorizationService;
    private AuctionHouseRepository auctionHouseRepository;

    public AuctionHouseService(PokemonCollectorRepository pokemonCollectorRepository, AuthorizationService authorizationService, AuctionHouseRepository auctionHouseRepository)
    {
        this.pokemonCollectorRepository = pokemonCollectorRepository;
        this.authorizationService = authorizationService;
        this.auctionHouseRepository = auctionHouseRepository;
    }

    public void createAuction(int amountToSell, double price, OwnedCard ownedCard) throws AuctionException
    {
        int id = authorizationService.getPokemonCollectorId();
        PokemonCollector pokemonCollector = pokemonCollectorRepository.findById(id).get();
        int amountOfCard = pokemonCollector.getOwnedCardList().get(ownedCard.getId()).getAmount();
        Auction auction;
        if(amountOfCard < amountToSell)
        {
            throw new AuctionException("You do not have that amount of this card");
        }
        else
        {
             auction = new Auction(amountToSell, price, ownedCard, pokemonCollector);
        }

        auctionHouseRepository.save(auction);
    }

    public List<OwnedCard> getAuctionPageContent()
    {
        int id = authorizationService.getPokemonCollectorId();
        return pokemonCollectorRepository.findById(id).get().getOwnedCardList();
    }
}
