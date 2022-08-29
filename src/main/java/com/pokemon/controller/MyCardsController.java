package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyCardsController
{
    @GetMapping("/my-cards")
    public String getHomePage()
    {
        return "my-cards";
    }

}
