package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionHouseController
{
    @GetMapping("/auction-house")
    public String getHomePage()
    {
        return "/auction-house";
    }
}
