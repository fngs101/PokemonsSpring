package com.pokemon.controller;

import com.pokemon.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class MainController
{
    AuthorizationService authorizationService;

    public MainController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }


    public boolean isUserLoggedIn()
    {
        return authorizationService.isUserLoggedIn();
    }
}