package com.pokemon.service;

import com.pokemon.domain.Auction;
import com.pokemon.domain.OwnedCard;
import com.pokemon.repository.PokemonCollectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionHouseService
{
    private PokemonCollectorRepository pokemonCollectorRepository;
    private AuthorizationService authorizationService;

    public AuctionHouseService(PokemonCollectorRepository pokemonCollectorRepository, AuthorizationService authorizationService)
    {
        this.pokemonCollectorRepository = pokemonCollectorRepository;
        this.authorizationService = authorizationService;
    }

    public void createAuction(int amountToSell, double price)
    {
        Auction auction = new Auction(amountToSell, price);
    }

    public List<OwnedCard> getAuctionPageContent()
    {
        int id = authorizationService.getPokemonCollectorId();
        return pokemonCollectorRepository.findById(id).get().getOwnedCardList();
    }
}
