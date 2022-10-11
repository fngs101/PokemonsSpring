package com.pokemon.controller;

import com.pokemon.domain.Card;
import com.pokemon.service.AuctionHouseService;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuctionHouseController implements MainController
{
    private AuthorizationService authorizationService;
    private AuctionHouseService auctionHouseService;

    public AuctionHouseController(AuthorizationService authorizationService, AuctionHouseService auctionHouseService)
    {
        this.authorizationService = authorizationService;
        this.auctionHouseService = auctionHouseService;
    }

    @GetMapping("/auction-house")
    public String getAuctionPage(Model model)
    {
        if(isUserLoggedIn())
        {
            List<Card> boughtCards =  authorizationService.getLoggedUserCollector().getCardList();
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

    @Override
    public boolean isUserLoggedIn()
    {
        return authorizationService.isUserLoggedIn();
    }
}
