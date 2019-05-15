package com.codecool.tictactoe.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Player {
    String userName;
    char sign;
}
