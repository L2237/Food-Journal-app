package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user")
@RequiredArgsConstructor
public class User {
    @Id
    @Column(name = "user_Id")
    private String userId;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
