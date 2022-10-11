package com.pokemon.controller;

import com.pokemon.domain.Card;
import com.pokemon.service.AuthorizationService;
import com.pokemon.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShopController implements MainController
{
    private ShopService shopService;
    private AuthorizationService authorizationService;

    public ShopController(ShopService shopService, AuthorizationService authorizationService)
    {
        this.shopService = shopService;
        this.authorizationService = authorizationService;
    }

    @GetMapping("/shop")
    public String getHomePage()
    {
        if(isUserLoggedIn())
        {
            return "shop";
        }
        else
        {
            return "index";
        }
    }

    @PostMapping("/shop")
    public String buy(Model model)
    {
        List<Card> pokemonCards = shopService.buy();
        model.addAttribute("pokemonCards", pokemonCards);
        return "shop";
    }

    @Override
    public boolean isUserLoggedIn()
    {
        return authorizationService.isUserLoggedIn();
    }
}
