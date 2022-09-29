package com.kodilla.tictactoe;

import org.apache.tomcat.util.bcel.classfile.ArrayElementValue;

public class LargeWinChecker {
    private int row;
    private int column;
    private String figure;
    private boolean win = false;
    private String[][] board;

    boolean isWin(int row, int column, String figure, String[][] board) {
        this.row = row;
        this.column = column;
        this.figure = figure;
        this.board = board;
        checkVertical();
        if (win == false) {
            checkHorizontal();
        }
        if (win == false) {
            checkCross();
        }
        return win;
    }

    private void checkVertical() {
        int x = 0;
        for (int i = row; i < 10; i++) {
            if (board[i][column].equals(figure)) {
                x++;
            } else {
                continue;
            }
        }
        for (int i = row; i > 0; i--) {
            if (board[i][column].equals(figure)) {
                x++;
            } else {
                continue;
            }
        }
        if (x >= 5) {
            win = true;
        }
    }

    private void checkHorizontal() {
        int y = 0;
        //check left
        for (int i = column; i < 10; i++) {
            if (board[row][i].equals(figure)) {
                y++;
            } else if (!board[row][i].equals(figure)) {
                continue;
            }
        }

        //check right
        for (int i = column; i > 0; i--) {
            if (board[row][i].equals(figure)) {
                y++;
            } else if (!board[row][i].equals(figure)) {
                continue;
            }
        }

        if (y >= 5) {
            win = true;
        }
    }

    private void checkCross() {
        int xy1 = 0;
        int xy2 = 0;
        int a = row;
        int b = column;
        for (int i = 0; i < 10; i++) {
            a++;
            b++;
            if (!(a > 9) && !(b > 9)) {
                if (board[a][b].equals(figure)) {
                    xy1++;
                }
            } else {
                continue;
            }
        }

        a = row;
        b = column;
        for (int i = 0; i < 10; i++) {
            a--;
            b--;
            if ((a >= 0) && (b >= 0)) {
                if (board[a][b].equals(figure)) {
                    xy1++;
                }
            } else {
                continue;
            }
        }

        a = row;
        b = column;
        for (int i = 0; i < 10; i++) {
            a--;
            b++;
            if ((a >= 0) && !(b > 9)) {
                if (board[a][b].equals(figure)) {
                    xy2++;
                }
            } else {
                continue;
            }
        }

        a = row;
        b = column;
        for (int i = 0; i < 10; i++) {
            a++;
            b--;
            if (!(a > 9) && (b >= 0)) {
                if (board[a][b].equals(figure)) {
                    xy2++;
                }
            } else {
                continue;
            }
        }

        if (xy1 == 4 || xy2 == 4) {
            System.out.println("WIN");
            System.exit(0);
        }
    }
}
