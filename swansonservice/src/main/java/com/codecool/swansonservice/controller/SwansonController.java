package com.codecool.swansonservice.controller;

import com.codecool.swansonservice.service.SwansonService;
import lombok.Data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Data
@RequestMapping("/ron")
public class SwansonController {

    @Autowired
    private SwansonService swansonService;

    @GetMapping("/swanson")
    public String retrieveSwansonism() {
        return swansonService.getSwansonism();
    }

}
