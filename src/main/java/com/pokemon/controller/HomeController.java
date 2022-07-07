package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
//    @RequestMapping(path="/home", method = RequestMethod.GET)
//    public ModelAndView getHomePage()
//    {
//        ModelAndView modelAndView = new ModelAndView("index.html");
//        return modelAndView;
//    }

    @GetMapping("/")
    public String getHomePageString()
    {
        return "index";
    }

}
