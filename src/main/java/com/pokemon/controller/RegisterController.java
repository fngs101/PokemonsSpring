package com.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController
{

    @GetMapping("/register")
    public String getHomePageString()
    {
        return "register";
    }

//podepnij css do html do static
    //jak podpiac w spring - spring mvc
    @PostMapping("/register")
    public String register(@RequestParam String email, String password, String passwordRepeat)
    {
        System.out.println("registering data");
        System.out.println(email);
        System.out.println(password);
        System.out.println(passwordRepeat);

        //zlecenie rejestracji do odpowiedniego serwisu wspolpracujacego z baza danych

        //wskazanie odpowieniego widoku
        return "mainPage";
    }
}
