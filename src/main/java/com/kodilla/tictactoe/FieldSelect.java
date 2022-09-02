package com.kodilla.tictactoe;

public class FieldSelect {
    Board board = new Board();
    void selectField(int fieldNumber, String figure) {
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
