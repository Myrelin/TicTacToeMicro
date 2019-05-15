package com.codecool.comicservice.controller;

import com.codecool.comicservice.model.Comic;
import com.codecool.comicservice.service.ComicService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/xkcd")
public class ComicServiceController {

    @Autowired
    private ComicService comicService;



    @GetMapping("/randomcomic")
    public Comic retrieveComic() {
/*        return new Comic(
                comicService.getRandomComic().getComicImage(),
                env.getProperty("server.port")
        );*/

        return comicService.getRandomComic();
    }
}
