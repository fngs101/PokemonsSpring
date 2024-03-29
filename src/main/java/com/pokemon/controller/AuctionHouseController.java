package com.pokemon.controller;

import com.pokemon.domain.Auction;
import com.pokemon.domain.OwnedCard;
import com.pokemon.exception.AuctionException;
import com.pokemon.repository.PokemonCollectorRepository;
import com.pokemon.service.AuctionHouseService;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/app/create-auction")
    public String getCreateAuctionView(Model model)
    {

        List<OwnedCard> boughtCards = auctionHouseService.getAuctionPageContent();
        model.addAttribute("boughtCards", boughtCards);

        return "create-auction";
    }

    @GetMapping("/app/auction-house")
    public String getAuctionPage()
    {

        return "auction-house";
    }

    @GetMapping("/app/my-auctions")
    public String getMyAuctionsPage(Model model)
    {
        List<Auction> myAuctions = auctionHouseService.getMyAuctionsPageContent();
        model.addAttribute("auctions", myAuctions);
        return "my-auctions";
    }

    @PostMapping("/create-auction/{ownedCardId}")
    public String createAuction(int amountToSell, double price, @PathVariable int ownedCardId, Model model)
    {
        try
        {
            Auction auction = auctionHouseService.createAuction(amountToSell, price, ownedCardId);
            if(auction != null)
            {
                model.addAttribute("auction", auction);
            }

        }
        catch (AuctionException e)
        {
            //dodac message do auction-house view
            System.out.println("error print - not enough cards to create auction");
        }

        return "redirect:/app/my-auctions";
    }

}
