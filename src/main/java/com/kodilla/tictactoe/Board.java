package com.kodilla.tictactoe;

public class Board {
    private String leftTop = " ";
    private String topMid = " ";
    private String rightTop = " ";
    private String leftMid = " ";
    private String mid = " ";
    private String rightMid = " ";
    private String leftBottom = " ";
    private String midBottom = " ";
    private String rightBottom = " ";
    private String result;

    public void setLeftTop(String leftTop) { this.leftTop = leftTop; }

    public void setTopMid(String topMid) {
        this.topMid = topMid;
    }

    public void setRightTop(String rightTop) {
        this.rightTop = rightTop;
    }

    public void setLeftMid(String leftMid) {
        this.leftMid = leftMid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setRightMid(String rightMid) {
        this.rightMid = rightMid;
    }

    public void setLeftBottom(String leftBottom) {
        this.leftBottom = leftBottom;
    }

    public void setMidBottom(String midBottom) {
        this.midBottom = midBottom;
    }

    public void setRightBottom(String rightBottom) {
        this.rightBottom = rightBottom;
    }

    String getField(int fieldNumber) {
        switch (fieldNumber) {
            case 1 -> result = leftTop;
            case 2 -> result = topMid;
            case 3 -> result = rightTop;
            case 4 -> result = leftMid;
            case 5 -> result = mid;
            case 6 -> result = rightMid;
            case 7 -> result = leftBottom;
            case 8 -> result = midBottom;
            case 9 -> result = rightBottom;
        }
        return result;
    }

    String showGameBoard() {
        return  "|" + leftTop + "|" + topMid + "|" + rightTop + "|\n" +
                "|" + leftMid + "|" + mid + "|" + rightMid + "|\n" +
                "|" + leftBottom + "|" + midBottom + "|" + rightBottom + "|";
    }

    String showBoardPattern() {
        return "|" + 1 + "|" + 2 + "|" + 3 + "|\n" +
                "|" + 4 + "|" + 5 + "|" + 6 + "|\n" +
                "|" + 7 + "|" + 8 + "|" + 9 + "|";
    }
}
