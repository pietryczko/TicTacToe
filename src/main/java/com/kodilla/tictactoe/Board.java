package com.kodilla.tictactoe;

public class Board {
    private String leftTop = "1";
    private String topMid = "2";
    private String rightTop = "3";
    private String leftMid = "4";
    private String mid = "5";
    private String rightMid = "6";
    private String leftBottom = "7";
    private String midBottom = "8";
    private String rightBottom = "9";

    void showBoard() {
        System.out.println("|" + leftTop + "|" + topMid + "|" + rightTop + "|\n" +
                "|" + leftMid + "|" + mid + "|" + rightMid + "|\n" +
                "|" + leftBottom + "|" + midBottom + "|" + rightBottom + "|");
    }

    public void setLeftTop(String leftTop) {
        this.leftTop = leftTop;
    }

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
}
