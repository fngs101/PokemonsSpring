package com.pokemon.controller;

import com.pokemon.request.LoginRequest;
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
    public String login(String email, String password)
    {
        LoginRequest loginRequest = new LoginRequest(email, password);

        return "";
    }
}
