package com.codecool.comicservice.service;

import com.codecool.comicservice.model.Comic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ComicService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Random random;

    private String comicUrl = "https://xkcd.com/";

    private String comicUrlJSON = "/info.0.json";


    public int getRandomComicNumber() {
        return random.nextInt(1001) + 1;
    }

    public Comic getRandomComic() {
        String url = comicUrl + getRandomComicNumber() + comicUrlJSON;
        Comic randomComic = restTemplate
                .getForObject(url, Comic.class);

        return randomComic;

    }
}
