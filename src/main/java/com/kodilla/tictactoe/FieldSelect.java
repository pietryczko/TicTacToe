package com.kodilla.tictactoe;

public class FieldSelect {
    private Board board = new Board();
    private boolean win = false;
    private boolean restart = false;
    private int winFigure;

    void selectField(int fieldNumber, String figure) throws OccupiedFieldException {
        if (board.getField(fieldNumber).equals("X") || board.getField(fieldNumber).equals("O")) {
            throw new OccupiedFieldException();
        } else {
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
    }

    void checkWinner() {
        if (board.getField(1).equals("X") || board.getField(1).equals("O")) {
            if (board.getField(1) == board.getField(2) && board.getField(2) == board.getField(3)) {
                win = true;
                winFigure = 1;
            } else if (board.getField(1) == board.getField(4) && board.getField(4) == board.getField(7)) {
                win = true;
                winFigure = 1;
            }
        } else if (board.getField(5).equals("X") || board.getField(5).equals("O"))
        if (board.getField(4) == board.getField(5) && board.getField(5) == board.getField(6)) {
            win = true;
            winFigure = 5;
        }
        if (board.getField(7) == board.getField(8) && board.getField(8) == board.getField(9)) {
            win = true;
            winFigure = 7;
        }
        if
        if (board.getField(2) == board.getField(5) && board.getField(5) == board.getField(8)) {
            win = true;
            winFigure = 5;
        }
        if (board.getField(3) == board.getField(6) && board.getField(6) == board.getField(9)) {
            win = true;
            winFigure = 3;
        }
        if (board.getField(1) == board.getField(5) && board.getField(5) == board.getField(9)) {
            win = true;
            winFigure = 5;
        }
        if (board.getField(7) == board.getField(5) && board.getField(5) == board.getField(3)) {
            win = true;
            winFigure = 5;
        }

        if (win) {
            System.out.println(board.getField(winFigure) + " won!");
            restart = true;
        }
    }

    String showGameBoard() {
        return board.showGameBoard();
    }

    boolean restartGame() {
        return restart;
    }
}
