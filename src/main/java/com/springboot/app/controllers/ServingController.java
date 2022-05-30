package com.springboot.app.controllers;

import com.springboot.app.entities.Serving;
import com.springboot.app.entities.dto.ServingDTO;
import com.springboot.app.servicies.ServingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServingController {

    private final ServingService servingService;

    @GetMapping(value = "/getServings")
    private List<Serving> getServings() {
        return servingService.getServings();
    }

    @PostMapping(value = "/addServing")
    public void addServing(@RequestBody ServingDTO servingDTO) {
        System.out.println(servingDTO.toString());
        servingService.addServing(servingDTO);
    }

}
