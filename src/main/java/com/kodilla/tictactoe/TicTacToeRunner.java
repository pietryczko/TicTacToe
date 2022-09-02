package com.kodilla.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeRunner {
    private final Scanner scanner = new Scanner(System.in);
    private Board board = new Board();
    private Figure figure = new Figure();
    private FieldSelect fieldSelect = new FieldSelect();

    private boolean exit = false;
    private int user1Field;
    private int user2Field;

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeRunner.class, args);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
        ticTacToeRunner.play();
    }

    void play() {
        while (!exit)
        figure.chooseFigure();
        board.showBoard();
        System.out.println("User1: \n" +
                "Select a field by pressing the appropriate number:");
        user1Field = scanner.nextInt();
        fieldSelect.selectField(user1Field, figure.getUser1Figure());
        System.out.println("User2: \n" +
                "Select a field by pressing the appropriate number:");
        user2Field = scanner.nextInt();
        fieldSelect.selectField(user2Field, figure.getUser2Figure());
    }
}
