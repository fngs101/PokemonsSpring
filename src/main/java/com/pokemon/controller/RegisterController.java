package com.pokemon.controller;

import com.pokemon.exception.RegisterServiceException;
import com.pokemon.request.RegisterRequest;
import com.pokemon.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController
{
    private RegisterService registerService;
    RegisterController(RegisterService registerService)
    {
        this.registerService = registerService;
    }
    @GetMapping("/register")
    public String getHomePageString()
    {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, String password, String passwordRepeat, Model model)
    {
        //adnotacja @RequestParam moze byc pominieta ale pozwala regulowac z dodatkiem pola "required" np. co moze byc przydatne
        System.out.println("registering data");
        RegisterRequest registerRequest = new RegisterRequest(email, password, passwordRepeat);
        try
        {
            registerService.register(registerRequest);
            model.addAttribute("message", "Registration completed");
            System.out.println("registration completed");
            return "main-page";
        } catch (RegisterServiceException e)
        {
            model.addAttribute("message", e.getMessage());
            System.out.println("registration failed");

            //160
        }
//strona profilu
        //statystyki
        //ustawienia
        //login page
        //kontrolery do tego i zbieraja dane serwis walidujący - nie kosmos, bo bedzie przerobka
        return "register";
    }
}
