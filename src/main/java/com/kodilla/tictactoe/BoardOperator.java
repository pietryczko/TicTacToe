package com.kodilla.tictactoe;

public class BoardOperator {

    private String[][] board = new String[10][10];


    void createBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = "-";
            }
        }
    }

    void showBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void changeField(int row, int column, String figure) {
        board[row][column] = figure;
    }

    String getField (int row, int column) {
        return  board[row][column];
    }
}

