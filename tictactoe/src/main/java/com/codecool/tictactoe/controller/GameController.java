package com.codecool.tictactoe.controller;

import com.codecool.tictactoe.Service.ServiceCaller;
import com.codecool.tictactoe.model.ComicSelection;
import com.codecool.tictactoe.model.Player;
import com.codecool.tictactoe.model.TicTacToeGame;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Data
@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    @Autowired
    ServiceCaller serviceCaller;

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TicTacToeGame getGame() {
        return new TicTacToeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }


    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player, Model model) {
        model.addAttribute("funfact", "&quot;Chuck Norris knows the last digit of pi.&quot;");
        model.addAttribute("comic_uri", serviceCaller.retrieveXKCD());
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("game") TicTacToeGame tictactoeGame, @ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        System.out.println(tictactoeGame.playerMovement(move));
        /*        System.out.println("Player moved " + move);*/
        return "redirect:/game";
    }

}
