package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
    public String getHomePage()
    {
        return "index";
    }

}
