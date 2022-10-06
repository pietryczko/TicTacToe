package com.kodilla.tictactoe;

import java.util.Scanner;

public class Figure {
    Scanner scanner = new Scanner(System.in);
    private String user1Figure;
    private String user2Figure;

    public void chooseFigure() {
        System.out.println("User 1:" +
                "Choose your figure -> X | O \n Press x to X / Press o to O");
        String user1Choose = scanner.next();
        if (user1Choose.equals("x")) {
            user1Figure = "X";
            user2Figure = "O";
        } else if (user1Choose.equals("o")) {
            user1Figure = "O";
            user2Figure = "X";
        } else {
            throw new IllegalArgumentException("Not recognized: " + user1Choose);
        }
        System.out.println("User 2 figure is: " + user2Figure);
    }

    public String getUser1Figure() {
        return user1Figure;
    }

    public String getUser2Figure() {
        return user2Figure;
    }
}
