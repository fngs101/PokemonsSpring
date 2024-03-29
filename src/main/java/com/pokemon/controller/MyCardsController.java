package com.pokemon.controller;

import com.pokemon.domain.OwnedCard;
import com.pokemon.domain.PokemonCollector;
import com.pokemon.repository.PokemonCollectorRepository;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyCardsController  extends MainController
{

    private PokemonCollectorRepository pokemonCollectorRepository;

    public MyCardsController(AuthorizationService authorizationService, PokemonCollectorRepository pokemonCollectorRepository)
    {
        super(authorizationService);
        this.pokemonCollectorRepository = pokemonCollectorRepository;
    }

    @GetMapping("/app/my-cards")
    public String getHomePage(Model model)
    {
        if(isUserLoggedIn())
        {
            PokemonCollector pokemonCollector =  pokemonCollectorRepository.findById(authorizationService.getPokemonCollectorId()).get();
            List<OwnedCard> boughtCards = pokemonCollector.getOwnedCardList();

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
}
