package com.kodilla.tictactoe.small;

import java.util.Objects;

public class FieldOperator {
    private final Board board = new Board();
    private boolean win = false;


    void selectField(int fieldNumber, String figure) {
        if (board.getField(fieldNumber).equals("X") || board.getField(fieldNumber).equals("O")) {
            throw new OccupiedFieldException();
        } else {
            fieldSelector(fieldNumber, figure);
        }
    }

    boolean fieldIsEmpty(int move) {
        return board.getField(move).isBlank();
    }

    void fieldSelector(int fieldNumber, String figure) {
        switch (fieldNumber) {
            case 1 -> board.setLeftTop(figure);
            case 2 -> board.setTopMid(figure);
            case 3 -> board.setRightTop(figure);
            case 4 -> board.setLeftMid(figure);
            case 5 -> board.setMid(figure);
            case 6 -> board.setRightMid(figure);
            case 7 -> board.setLeftBottom(figure);
            case 8 -> board.setMidBottom(figure);
            case 9 -> board.setRightBottom(figure);
        }
    }

    void checkWinner() {
        int winFigure = 0;
        if (!board.getField(5).isBlank()) {
            if (Objects.equals(board.getField(4), board.getField(5)) && Objects.equals(board.getField(5), board.getField(6))) {
                win = true;
                winFigure = 5;
            } else if (Objects.equals(board.getField(2), board.getField(5)) && Objects.equals(board.getField(5), board.getField(8))) {
                win = true;
                winFigure = 5;
            } else if (Objects.equals(board.getField(7), board.getField(5)) && Objects.equals(board.getField(5), board.getField(3))) {
                win = true;
                winFigure = 5;
            } else if (Objects.equals(board.getField(1), board.getField(5)) && Objects.equals(board.getField(5), board.getField(9))) {
                win = true;
                winFigure = 5;
            }
        }
        if (board.getField(1).equals("X") || board.getField(1).equals("O")) {
            if (Objects.equals(board.getField(1), board.getField(2)) && Objects.equals(board.getField(2), board.getField(3))) {
                win = true;
                winFigure = 1;
            } else if (Objects.equals(board.getField(1), board.getField(4)) && Objects.equals(board.getField(4), board.getField(7))) {
                win = true;
                winFigure = 1;
            }
        }
        if ((board.getField(9).equals("X") || board.getField(9).equals("O"))) {
            if (Objects.equals(board.getField(3), board.getField(6)) && Objects.equals(board.getField(6), board.getField(9))) {
                win = true;
                winFigure = 3;
            }
            if (Objects.equals(board.getField(7), board.getField(8)) && Objects.equals(board.getField(8), board.getField(9))) {
                win = true;
                winFigure = 7;
            }
        }

        if (win) {
            System.out.println(showGameBoard());
            System.out.println(board.getField(winFigure) + " won!");
        }
        isDraw();
    }

    boolean isDraw() {
        if (!board.getField(1).isBlank() &&
                !board.getField(2).isBlank() &&
                !board.getField(3).isBlank() &&
                !board.getField(4).isBlank() &&
                !board.getField(5).isBlank() &&
                !board.getField(6).isBlank() &&
                !board.getField(7).isBlank() &&
                !board.getField(8).isBlank() &&
                !board.getField(9).isBlank() &&
                !win) {
            System.out.println("DRAW!");
        }
        return true;
    }

    void clearBoard() {
        for (int i = 0; i < 10; i++) {
            fieldSelector(i, " ");
        }
        win = false;
    }

    String showGameBoard() {
        return board.showGameBoard();
    }

    boolean isWin() {
        return win;
    }

}