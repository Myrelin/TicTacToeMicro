package com.codecool.tictactoe.Service;

import com.codecool.tictactoe.model.AvatarSelection;
import com.codecool.tictactoe.model.ComicSelection;
import com.codecool.tictactoe.model.SwansonismSelection;
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

    @Value(("${avatar.url}"))
    private String avatarUrl;

    @Value("${swanson.url}")
    private String swansonismUrl;

    public String retrieveXKCD() {
        ComicSelection body = restTemplate.getForEntity(comicUrl, ComicSelection.class).getBody();
        return body.getImg();
    }

    public String retrieveAvatar() {
        AvatarSelection body = restTemplate.getForEntity(avatarUrl, AvatarSelection.class).getBody();
        return body.getAvatar();
    }

    public String retrieveSwansonism() {
        SwansonismSelection body = restTemplate.getForEntity(swansonismUrl, SwansonismSelection.class).getBody();
        return body.getSwansonism();
    }
}
