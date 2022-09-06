package com.kodilla.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeRunner {
    private final Scanner scanner = new Scanner(System.in);
    private FieldSelect fieldSelect = new FieldSelect();
    private Figure figure = new Figure();
    private Board board = new Board();


    private boolean exit = false;
    private boolean error;
    private int user1Field;
    private int user2Field;

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeRunner.class, args);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();

        ticTacToeRunner.play();
    }

    void play() {
        figure.chooseFigure();
        while (!exit) {
            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1Play();

            showBoards();
            Comments.USER_2_FIELD_SELECT();
            user2Play();
        }
    }

    void showBoards() {
        System.out.println("Field numbers:\n" + board.showBoardPattern()+ "\n\nCurrent Game:\n" + fieldSelect.showGameBoard());
    }
    void user1Play() {
        error = false;
        do {
            user1Field = scanner.nextInt();
            try {
                fieldSelect.selectField(user1Field, figure.getUser1Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                System.out.println("Field is occupied, try another one");
                error = true;
            }
        } while (error);
    }
    void user2Play() {
        error = false;
        do {
            user2Field = scanner.nextInt();
            try {
                fieldSelect.selectField(user2Field, figure.getUser2Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                System.out.println("Field is occupied, try another one");
                error = true;
            }
        } while (error);
    }
}
