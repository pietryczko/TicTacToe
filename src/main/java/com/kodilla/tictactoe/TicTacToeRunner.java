package com.kodilla.tictactoe;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TicTacToeRunner {

    public static void main(String[] args) {
        GameProcessor gameProcessor = new GameProcessor();
        while (gameProcessor.startGame()) {
            gameProcessor = new GameProcessor();
        }
    }
}
