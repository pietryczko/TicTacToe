package com.kodilla.tictactoe.large;

import com.kodilla.tictactoe.Figure;

import java.util.Scanner;

public class LargeBoardOperator {
    private final LargeWinChecker winChecker = new LargeWinChecker();
    private final Figure figure = new Figure();
    private final Scanner scanner = new Scanner(System.in);
    private final String[][] board = new String[10][10];
    private boolean win = false;


    private void createBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "-";
            }
        }
    }

    private void showBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void chooseField(String figure) {
        int row;
        int column;
        boolean repeat = true;
        do {
            System.out.println("Select row");
            row = scanner.nextInt() - 1;
            System.out.println("Select column");
            column = scanner.nextInt() - 1;
            if (board[row][column].equals("-")) {
                board[row][column] = figure;
                repeat = false;
            } else {
                System.out.println("Field is occupied, try other");
            }
        } while (repeat);
        if (winChecker.isWin(row, column, figure, board)) {
            System.out.println(figure + " win!");
            win = true;
        }
    }

    private boolean isWin() {
        return win;
    }

    public void startLarge() {
        boolean exit = false;
        createBoard();
        figure.chooseFigure();
        while (!exit) {
            showBoard();
            chooseField(figure.getUser1Figure());
            if (isWin()) {
                break;
            }
            showBoard();
            chooseField(figure.getUser2Figure());
            if (isWin()) {
                break;
            }
        }
    }
}