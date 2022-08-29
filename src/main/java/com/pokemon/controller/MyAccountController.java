package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyAccountController
{
    @GetMapping("/my-account")
    public String getHomePage()
    {
        return "/my-account";
    }
}
