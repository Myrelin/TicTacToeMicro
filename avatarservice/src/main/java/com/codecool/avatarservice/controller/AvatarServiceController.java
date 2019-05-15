package com.codecool.avatarservice.controller;

import com.codecool.avatarservice.service.AvatarService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/avatar")
public class AvatarServiceController {

    @Autowired
    private AvatarService avatarService;

    @GetMapping("/randomavatar")
    public String retrieveAvatar() {
        return avatarService.generateAvatar();
    }
}
