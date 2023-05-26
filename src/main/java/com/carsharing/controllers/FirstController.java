package com.carsharing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @Autowired
    public FirstController() {
    }

    @GetMapping("/login")
    public String goToLogin(){
        return "client/entrance";
    }
}
