package com.springboot.app.controllers;

import com.springboot.app.entities.User;
import com.springboot.app.entities.dto.LoginDTO;
import com.springboot.app.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<String> signin(@RequestBody LoginDTO loginDTO) throws Exception {
        if(userService.signIn(loginDTO)) {
            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User could not sign in!", HttpStatus.UNAUTHORIZED);
        }
    }

}



