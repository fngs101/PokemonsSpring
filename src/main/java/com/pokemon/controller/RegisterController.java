package com.pokemon.controller;

import com.pokemon.exception.AuthorizationServiceException;
import com.pokemon.request.RegisterRequest;
import com.pokemon.service.AuthorizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RegisterController
{
    private AuthorizationService authorizationService;
    RegisterController(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }
    @GetMapping("/register")
    public String getHomePage(Model model)
    {
        RegisterRequest registerRequest = new RegisterRequest();
        model.addAttribute("registerRequest", registerRequest);

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterRequest registerRequest, BindingResult bindingResult, Model model)
    {
        //te parametry w tej metodzie są identyczne do tych w html w register, w polu name, wtedy Spring wie skad je brac
        //adnotacja @RequestParam moze byc pominieta ale pozwala regulowac z dodatkiem pola "required" np. co moze byc przydatne

        try
        {
            if(bindingResult.hasErrors())
            {

                System.err.println("tutaj jest error w regiester");
                return "register";
            }
            authorizationService.register(registerRequest);
            model.addAttribute("message", "Welcome to the Pokémon world, new user!");
            return "login";
        } catch (AuthorizationServiceException e)
        {
//            model.addAttribute("errorMessage", e.getMessage());
            bindingResult.addError(new FieldError("registerRequest", "email", e.getMessage()));

            return "register";
        }
    }
}
