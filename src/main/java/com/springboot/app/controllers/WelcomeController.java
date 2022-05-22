package com.springboot.app.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to our food journal! ";
    }

}
