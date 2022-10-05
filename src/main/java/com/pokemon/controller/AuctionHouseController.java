package com.pokemon.controller;

import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionHouseController
{
    private AuthorizationService authorizationService;

    public AuctionHouseController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/auction-house")
    public String getHomePage()
    {
        if(authorizationService.isUserLoggedIn())
        {
            return "auction-house";
        }
        else
        {
            return "index";
        }
    }

}
