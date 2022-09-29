package com.pokemon.controller;

import com.pokemon.exception.AuthorizationServiceException;
import com.pokemon.request.LoginRequest;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{

    private AuthorizationService authorizationService;
    LoginController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }
    @GetMapping("/login")
    public String getHomePage()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password, Model model)
    {
        LoginRequest loginRequest = new LoginRequest(email, password);
        try
        {
            authorizationService.login(loginRequest);
            model.addAttribute("message", "Welcome back to the Pokémon world!");
            return "my-account";
        } catch (AuthorizationServiceException e)
        {
            model.addAttribute("errorMessage", e.getMessage());

            return "login";
        }

    }
}
