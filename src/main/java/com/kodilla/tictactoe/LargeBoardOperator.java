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

    void checkWinner(int row, int column, String figure) {
        int x = 0;
        int y = 0;
        //check down
        for (int i = row; i < 10; i++) {
            if (board[i][column].equals(figure)) {
                x++;
            } else if (!board[i][column].equals(figure)) {
                break;
            }
        }

        if (x > 0) {
            x--;
        }
        for (int i = row; i > 0; i--) {

            if (board[i][column].equals(figure)) {
                x++;
            } else if (!board[i][column].equals(figure)) {
                break;
            }
        }


        for (int i = column; i < 10; i++) {
            if (board[row][i].equals(figure)) {
                y++;
            } else if (!board[row][i].equals(figure)) {
                break;
            }
        }

        if (y > 0) {
            y--;
        }
        for (int i = column; i > 0; i--) {
            if (board[row][i].equals(figure)) {
                y++;
            } else if (!board[row][i].equals(figure)) {
                break;
            }
        }

        int xy1 = 0;
        int xy2 = 0;
        for (int i = 0; i < 10; i++) {
            row++;
            column++;
            if (!(row > 9) && !(column > 9)) {
                if (board[row][column].equals(figure)) {
                    xy1++;
                }
            } else {
                break;
            }
            System.out.println(xy1);
        }
        for (int i = row; i < 10; i++) {
            for (int j = column; j < 10; j++) {
                if (board[i][j].equals(figure)) {
                    xy1++;
                } else if (!board[i][j].equals(figure)) {
                    break;
                }
            }
            for (int j = column; j < 0; j--) {
                if (board[i][j].equals(figure)) {
                    xy2++;
                } else if (!board[i][j].equals(figure)) {
                    break;
                }
            }
        }

        if (y > 0) {
            xy1--;
        }
        if (y > 0) {
            xy2--;
        }
        for (int i = row; i < 0; i--) {
            for (int j = column; j < 10; j++) {
                if (board[i][j].equals(figure)) {
                    xy1++;
                } else if (!board[i][j].equals(figure)) {
                    break;
                }
            }
            for (int j = column; j < 0; j--) {
                if (board[i][j].equals(figure)) {
                    xy2++;
                } else if (!board[i][j].equals(figure)) {
                    break;
                }
            }

        }

        if (x == 5 || y == 5 || xy1 == 5 || xy2 == 5) {
            System.out.println("WIN");
            System.exit(0);
        }
    }
}