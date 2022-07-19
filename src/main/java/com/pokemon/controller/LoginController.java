package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{

    @GetMapping("/login")
    public String getHomePage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login()
    {

//        RegisterRequest registerRequest = new RegisterRequest(email, password, passwordRepeat);
//        try
//        {
////            registerService.register(registerRequest);
//            model.addAttribute("message", "Registration completed");
//            System.out.println("registration completed");
//            return "main-page";
//        } catch (RegisterServiceException e)
//        {
//            model.addAttribute("message", e.getMessage());
//            System.out.println("registration failed");
                //return "register";
//
//        }

        return "";
    }
}
