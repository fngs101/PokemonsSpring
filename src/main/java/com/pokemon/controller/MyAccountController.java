package com.pokemon.controller;

import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAccountController extends MainController
{

    public MyAccountController(AuthorizationService authorizationService)
    {
        super(authorizationService);
    }

    @GetMapping("/app/my-account")
    public String getHomePage()
    {
        if(isUserLoggedIn())
        {
            return "my-account";
        }
        else
        {
            return "index";
        }
    }

}
