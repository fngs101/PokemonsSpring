package com.pokemon.controller;

import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAccountController
{
    private AuthorizationService authorizationService;

    public MyAccountController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/my-account")
    public String getHomePage()
    {
        if(authorizationService.isUserLoggedIn())
        {
            return "my-account";
        }
        else
        {
            return "index";
        }
    }


}
