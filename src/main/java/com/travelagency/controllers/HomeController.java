package com.travelagency.controllers;

import com.travelagency.repositories.CityRepository;
import com.travelagency.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping("")
    public String getHomePage(Model model){
        model.addAttribute("home",true);
        model.addAttribute("view","home-page");
        return "base-layout";
    }
}
