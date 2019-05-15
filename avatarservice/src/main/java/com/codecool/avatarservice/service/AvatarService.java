package com.codecool.avatarservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class AvatarService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Random random;

    private String avatarUrl = "https://api.adorable.io/avatars/285/";
    private String fileExtension = ".png";

    public int getRandomAvatarNumber() {
        return random.nextInt(1000);
    }

    public String generateAvatar() {
       return avatarUrl + getRandomAvatarNumber() + fileExtension;
//        Avatar randomAvatar = restTemplate
//                .getForObject(url, Avatar.class);

    }
}
