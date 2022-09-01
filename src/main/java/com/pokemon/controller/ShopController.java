package com.pokemon.controller;

import com.pokemon.domain.Card;
import com.pokemon.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShopController
{
    private ShopService shopService;

    public ShopController(ShopService shopService)
    {
        this.shopService = shopService;
    }

    @GetMapping("/shop")
    public String getHomePage()
    {
        return "shop";
    }

    @PostMapping("/shop")
    public String buy(Model model)
    {
        List<Card> pokemonCards = shopService.buy();
        model.addAttribute("pokemonCards", pokemonCards);
        System.out.println(pokemonCards.get(0).getUrl());
        return "shop";
    }
}
