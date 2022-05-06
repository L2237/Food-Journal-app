package com.springboot.app.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to our food journal";
    }

    @PostMapping
    public String createPostRoute() {
        return "Resursa a fost adaugata cu succes";
    }

    @PutMapping
    public String createPutRoute() {
        return "Resursa a fost actualizată cu succes";
    }

    @DeleteMapping
    public String createDeleteRoute() {
        return "Resursa a fost ștearsă cu succes";
    }

    @GetMapping
    public String createGetRoute() {
        return "Resursa X";
    }

}
