package com.codecool.tictactoe.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TicTacToeGame {
    private Player player;
    private int turn;
    private boolean gameWon = false;
    private char[] board = {'0', '0', '0',
            '0', '0', '0',
            '0', '0', '0'};

    public String playerMovement(int move) {
        if (this.turn < 9 && !checkIfSquareTaken(move)) {
            this.board[move] = 'x';
            this.setTurn(turn ++);
            checkIfGameWon('x');
            if (gameWon) {
                return "Congratulations, you won!";
            } else {
                return "Player moved to" + move;
            }
        } else if (this.turn == 9 & !this.gameWon) {
            return "It's a tie!";
        } else {
            return "Place taken, try again";
        }
    }

    public boolean checkIfSquareTaken(int move) {
        return this.board[move] != '0';
    }

    public void checkIfGameWon(char playerSign) {
        if ((board[0] == playerSign && board[1] == playerSign && board[2] == playerSign) ||
                (board[3] == playerSign && board[4] == playerSign && board[5] == playerSign) ||
                (board[6] == playerSign && board[7] == playerSign && board[8] == playerSign) ||
                (board[0] == playerSign && board[3] == playerSign && board[6] == playerSign) ||
                (board[1] == playerSign && board[4] == playerSign && board[7] == playerSign) ||
                (board[2] == playerSign && board[5] == playerSign && board[8] == playerSign) ||
                (board[0] == playerSign && board[4] == playerSign && board[8] == playerSign) ||
                (board[2] == playerSign && board[4] == playerSign && board[6] == playerSign)){
            setGameWon(true);
        }
    }
}
