package com.kodilla.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeRunner {
    private final Scanner scanner = new Scanner(System.in);
    private LargeBoardOperator large = new LargeBoardOperator();
    private ThreeByThreeOP small = new ThreeByThreeOP();

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeRunner.class, args);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
        ticTacToeRunner.startGame();
    }

    void startGame() {
        System.out.println("Press 1 to play small Tic Tac Toe\nPress 2 to play large Tic Tac Toe");
        int gameMode = scanner.nextInt();

        if (gameMode == 1) {
            small.startSmall();
        } else if (gameMode == 2) {
            large.startLarge();
        }

        System.out.println("Do you want play again? y/n");
        if (scanner.next().equals("y")) {
            startGame();
        } else {
            System.exit(0);
        }

    }
}
