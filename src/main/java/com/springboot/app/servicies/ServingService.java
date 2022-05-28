package com.springboot.app.servicies;

import com.springboot.app.entities.Serving;
import com.springboot.app.repositories.ServingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServingService {

    @Autowired
    private ServingRepository servingRepository;

    public List<Serving> getServings() {
        return servingRepository.findAll();
    }

}