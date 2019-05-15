package com.codecool.comicservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class Comic {

    @JsonProperty("img")
    private String comicImage;


}
