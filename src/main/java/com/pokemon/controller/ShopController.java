package com.pokemon.controller;

import com.pokemon.domain.Card;
import com.pokemon.exception.ShopServiceException;
import com.pokemon.service.AuthorizationService;
import com.pokemon.service.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShopController extends MainController
{
    private ShopService shopService;
    private AuthorizationService authorizationService;

    public ShopController(ShopService shopService, AuthorizationService authorizationService)
    {
        super(authorizationService);
        this.shopService = shopService;
    }

    @GetMapping("/app/shop")
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

    @PostMapping("/app/shop")
    public String buy(Model model)
    {
        List<Card> pokemonCards;
        try
        {
            pokemonCards = shopService.buy();
            model.addAttribute("pokemonCards", pokemonCards);
        }
        catch (ShopServiceException e)
        {
            model.addAttribute("disabled", true);
            model.addAttribute("message", "You cannot afford buying any cards");
        }

        return "shop";
    }

}
