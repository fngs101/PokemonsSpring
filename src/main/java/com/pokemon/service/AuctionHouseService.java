package com.pokemon.service;

import com.pokemon.domain.Auction;
import com.pokemon.domain.OwnedCard;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.exception.AuctionException;
import com.pokemon.repository.AuctionHouseRepository;
import com.pokemon.repository.OwnedCardRepository;
import com.pokemon.repository.PokemonCollectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionHouseService
{
    private PokemonCollectorRepository pokemonCollectorRepository;
    private AuthorizationService authorizationService;
    private AuctionHouseRepository auctionHouseRepository;
    private OwnedCardRepository ownedCardRepository;

    public AuctionHouseService(PokemonCollectorRepository pokemonCollectorRepository, AuthorizationService authorizationService,
                               AuctionHouseRepository auctionHouseRepository, OwnedCardRepository ownedCardRepository)
    {
        this.pokemonCollectorRepository = pokemonCollectorRepository;
        this.authorizationService = authorizationService;
        this.auctionHouseRepository = auctionHouseRepository;
        this.ownedCardRepository = ownedCardRepository;
    }

    public void createAuction(int amountToSell, double price, int ownedCardId) throws AuctionException
    {
        int id = authorizationService.getPokemonCollectorId();
        PokemonCollector pokemonCollector = pokemonCollectorRepository.findById(id).get();
        OwnedCard ownedCard = pokemonCollector.getOwnedCardList().get(ownedCardId);
        int amountOfCard = ownedCard.getAmount();

        if(amountOfCard < amountToSell)
        {
            throw new AuctionException("You do not have that amount of this card");
        }

        Auction auction = new Auction(amountToSell, price, ownedCard.getCard(), pokemonCollector);

        ownedCard.setAmount(amountOfCard - 1);
        if(ownedCard.getAmount() == 0)
        {
            //todo usunac caly rekord z tabeli? a co jesli dwoch pokemoncollectors bedzie mialo te sama karte? nie brakuje czegos w bazie jak to powiazac z danym collectorem?
            ownedCardRepository.deleteById(ownedCard.getId());
        }
        else
        {
            ownedCardRepository.save(ownedCard);
        }

        auctionHouseRepository.save(auction);
    }

    public List<OwnedCard> getAuctionPageContent()
    {
        int id = authorizationService.getPokemonCollectorId();
        return pokemonCollectorRepository.findById(id).get().getOwnedCardList();
    }
}
