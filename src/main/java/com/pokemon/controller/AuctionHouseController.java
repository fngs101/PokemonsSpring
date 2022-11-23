package com.pokemon.controller;

import com.pokemon.domain.OwnedCard;
import com.pokemon.exception.AuctionException;
import com.pokemon.repository.PokemonCollectorRepository;
import com.pokemon.service.AuctionHouseService;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuctionHouseController extends MainController
{
    private AuctionHouseService auctionHouseService;

    public AuctionHouseController(AuthorizationService authorizationService, AuctionHouseService auctionHouseService)
    {
        super(authorizationService);
        this.auctionHouseService = auctionHouseService;

    }

    @GetMapping("/app/auction-house")
    public String getAuctionPage(Model model)
    {

        List<OwnedCard> boughtCards = auctionHouseService.getAuctionPageContent();
        model.addAttribute("boughtCards", boughtCards);

        return "auction-house";
    }

    @PostMapping("/create-auction")
    public String createAuction(int amountToSell, double price, OwnedCard ownedcard)
    {
        try
        {
            auctionHouseService.createAuction(amountToSell, price, ownedcard);
        }
        catch (AuctionException e)
        {
            throw new RuntimeException(e);
        }

        return "auction-house";
    }

}
