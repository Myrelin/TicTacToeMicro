package com.codecool.tictactoe.Service;

import com.codecool.tictactoe.model.ComicSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${comic.url}")
    private String comicUrl;

    public String retrieveXKCD() {
        ComicSelection body = restTemplate.getForEntity(comicUrl, ComicSelection.class).getBody();
        return body.getImg();
    }
}
