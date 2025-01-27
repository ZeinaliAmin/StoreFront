package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class aboutController {

    public aboutController() {
    }

    @GetMapping("/about")
    public String getAbout(){

        return "about";

    }


}
