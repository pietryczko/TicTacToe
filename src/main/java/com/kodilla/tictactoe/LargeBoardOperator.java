package com.kodilla.tictactoe;

import java.util.Scanner;

public class LargeBoardOperator {
    private Scanner scanner = new Scanner(System.in);
    private String[][] board = new String[10][10];


    void createBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "-";
            }
        }
        board[1][1] = "X";
        board[2][2] = "X";

        board[2][4] = "X";
        board[1][5] = "X";

        board[4][2] = "X";
        board[5][1] = "X";

        board[4][4] = "X";
        board[5][5] = "X";

    }

    void showBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void chooseField(String figure) {
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
        checkWinner(row, column, figure);
    }


    String getField(int row, int column) {
        return board[row][column];
    }
}
/* else if (!getField(i, column).equals(figure)){
         return;
         }*/

