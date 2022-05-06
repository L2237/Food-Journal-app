package com.springboot.app.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("login")
    public String createPostRouteL(@PathVariable final String userName, @PathVariable final String password) {

        // check in DB (user-ul exista)
        // daca exista atunci returnezi "



        return "I work too";
    }

    @GetMapping("/user")
    public String createLogin(String mail, String parola) {
//        boolean existaUtilizator = false;
//        User user = new User("mail", "pass");
//        if (user.email.equals(mail) && user.password.equals(parola)) {
//
//            existaUtilizator = true;
//        }
        return "Te-ai logat cu success";
    }
}



