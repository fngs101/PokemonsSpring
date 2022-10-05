package com.pokemon.controller;

import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyCardsController
{
    private AuthorizationService authorizationService;

    public MyCardsController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/my-cards")
    public String getHomePage()
    {
        if(authorizationService.isUserLoggedIn())
        {
            return "my-cards";
        }
        else
        {
            return "index";
        }
    }

}
