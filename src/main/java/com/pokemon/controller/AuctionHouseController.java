package com.pokemon.controller;
import com.pokemon.domain.OwnedCard;
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

    @GetMapping("/auction-house")
    public String getAuctionPage(Model model)
    {
        if(isUserLoggedIn())
        {
            List<OwnedCard> boughtCards =  authorizationService.getLoggedUserCollector().getOwnedCardList();
            model.addAttribute("boughtCards", boughtCards);
            return "auction-house";
        }
        else
        {
            return "index";
        }
    }

    @PostMapping("/create-auction")
    public String createAuction(int amountToSell, double price, Model model)
    {
        auctionHouseService.createAuction(amountToSell, price);

        return "auction-house";
    }

}
