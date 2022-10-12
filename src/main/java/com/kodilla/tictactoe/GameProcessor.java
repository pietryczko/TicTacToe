package com.kodilla.tictactoe;

import com.kodilla.tictactoe.large.LargeBoardOperator;
import com.kodilla.tictactoe.small.ThreeByThreeOP;

import java.util.Scanner;

public class GameProcessor {

    private final Scanner scanner = new Scanner(System.in);
    private final LargeBoardOperator large = new LargeBoardOperator();
    private final ThreeByThreeOP small = new ThreeByThreeOP();

    boolean startGame() {
        System.out.println("Press 1 to play small Tic Tac Toe\nPress 2 to play large Tic Tac Toe");
        int gameMode = scanner.nextInt();

        if (gameMode == 1) {
            small.startSmall();
        } else if (gameMode == 2) {
            large.startLarge();
        }

        System.out.println("Do you want play again? y/n");
        return scanner.next().equals("y");
    }
}
