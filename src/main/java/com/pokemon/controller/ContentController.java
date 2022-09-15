package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController
{
    @GetMapping("/content")
    public String getHomePage()
    {
        return "content.html";
    }
}
