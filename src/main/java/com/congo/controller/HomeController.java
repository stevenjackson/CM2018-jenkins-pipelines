package com.congo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Value("${flagOn}")
    private Boolean flagOn;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("userId", 1);
        mav.addObject("flagOn", flagOn);
        return mav;
    }
}