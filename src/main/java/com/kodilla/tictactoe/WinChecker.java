package com.kodilla.tictactoe;

public class WinChecker {
    private LargeBoardOperator boardOperator = new LargeBoardOperator();
    private int row;
    private int column;
    private String figure;
    private int x = 0;
    private int y = 0;


    void checkWinner(int row, int column, String figure) {
        this.row = row;
        this.column = column;
        this.figure = figure;
        checkDown();
        checkUp();
        checkLeft();
        checkRight();
        checkAngle();
        getWin();
    }

    private void checkDown() {
        //check down
        for (int i = row; i < 10; i++) {
            if (boardOperator.getField(i, column).equals(figure)) {
                x++;
            } else if (!boardOperator.getField(i, column).equals(figure)) {
                break;
            }
        }
    }

    void checkUp() {
        if (x > 0) {
            x--;
        }
        for (int i = row; i > 0; i--) {

            if (boardOperator.getField(i, column).equals(figure)) {
                x++;
            } else if (!boardOperator.getField(i, column).equals(figure)) {
                break;
            }
        }
    }

    void checkRight() {
        for (int i = column; i < 10; i++) {
            if (boardOperator.getField(row, i).equals(figure)) {
                y++;
            } else if (!boardOperator.getField(row, i).equals(figure)) {
                break;
            }
        }
    }

    void checkLeft() {
        if (y > 0) {
            y--;
        }
        for (int i = column; i > 0; i--) {
            if (boardOperator.getField(row, i).equals(figure)) {
                y++;
            } else if (!boardOperator.getField(row, i).equals(figure)) {
                break;
            }
        }
    }

    void checkAngle() {
        for (int i = row; i < 10; i++) {
            for (int j = column; j < 10; j++) {
                if (boardOperator.getField(row, column).equals(figure)) {
                    y++;
                } else if (!boardOperator.getField(row, i).equals(figure)) {
                    break;
                }
            }
            for (int j = column; j < 0; j--) {
                if (boardOperator.getField(row, column).equals(figure)) {
                    y++;
                } else if (!boardOperator.getField(row, i).equals(figure)) {
                    break;
                }
            }
        }

        for (int i = row; i < 0; i--) {
            for (int j = column; j < 10; j++) {
                if (boardOperator.getField(row, column).equals(figure)) {
                    y++;
                } else if (!boardOperator.getField(row, i).equals(figure)) {
                    break;
                }
            }
            for (int j = column; j < 0; j--) {
                if (boardOperator.getField(row, column).equals(figure)) {
                    y++;
                } else if (!boardOperator.getField(row, i).equals(figure)) {
                    break;
                }
            }
        }
    }

    void getWin() {
        if (x == 5 || y == 5) {
            System.out.println("WIN");
            System.exit(0);
        }
    }
}
