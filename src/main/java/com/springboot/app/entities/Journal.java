package com.springboot.app.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Journal {
    private User user;
    private List<Meal> food;
}
