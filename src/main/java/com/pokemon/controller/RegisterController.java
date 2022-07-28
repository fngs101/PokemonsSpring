package com.pokemon.controller;

import com.pokemon.exception.AuthorizationServiceException;
import com.pokemon.request.RegisterRequest;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController
{
    private AuthorizationService authorizationService;
    RegisterController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }
    @GetMapping("/register")
    public String getHomePage()
    {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, String password, String passwordRepeat, Model model)
    {
        //adnotacja @RequestParam moze byc pominieta ale pozwala regulowac z dodatkiem pola "required" np. co moze byc przydatne
        RegisterRequest registerRequest = new RegisterRequest(email, password, passwordRepeat);
        try
        {
            authorizationService.register(registerRequest);
            model.addAttribute("message", "Welcome to the Pokémon world, new user!");
            return "main-page";
        } catch (AuthorizationServiceException e)
        {
            model.addAttribute("message", e.getMessage());

            return "register";
        }
    }
}
