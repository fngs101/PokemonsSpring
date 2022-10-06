package com.pokemon.controller;

import com.pokemon.domain.Card;
import com.pokemon.repository.PokemonCollectorRepository;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyCardsController
{
    private AuthorizationService authorizationService;
    private PokemonCollectorRepository pokemonCollectorRepository;

    public MyCardsController(AuthorizationService authorizationService, PokemonCollectorRepository pokemonCollectorRepository)
    {
        this.authorizationService = authorizationService;
        this.pokemonCollectorRepository = pokemonCollectorRepository;
    }

    @GetMapping("/my-cards")
    public String getHomePage(Model model)
    {
        if(authorizationService.isUserLoggedIn())
        {
            List<Card> boughtCards =  authorizationService.getLoggedUserCollector().getCardList();

            //todo wywalic ten if i stescic
            if(!boughtCards.isEmpty())
            {
                model.addAttribute("boughtCards", boughtCards);
            }
            return "my-cards";
        }
        else
        {
            return "index";
        }
    }

//    @PostMapping("/my-cards")
//    public String showBoughtCards(Model model)
//    {
//       List<Card> boughtCards =  pokemonCollector.getCardList();
//        model.addAttribute("boughtCards", boughtCards);
//        System.out.println(boughtCards.get(0).getUrl());
//        return "my-cards";
//    }

}
