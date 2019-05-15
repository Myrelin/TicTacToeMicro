package com.codecool.swansonservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SwansonService {

    @Autowired
    RestTemplate restTemplate;

    private String swansonUrl = "https://ron-swanson-quotes.herokuapp.com/v2/quotes";

    public String getSwansonism() {
        String randomSwansonism = restTemplate
                .getForObject(swansonUrl, String.class);

        return randomSwansonism;
    }
}
