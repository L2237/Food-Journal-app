package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private String userId;
    private String userName;
    private String email;
    private String password;
}
