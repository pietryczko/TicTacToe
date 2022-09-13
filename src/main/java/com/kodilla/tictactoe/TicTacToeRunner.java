package com.kodilla.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeRunner {
    private boolean exit = false;
    private boolean error;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final FieldOperator fieldOperator = new FieldOperator();
    private final Figure figure = new Figure();
    private final Board board = new Board();

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeRunner.class, args);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
        ticTacToeRunner.start();
    }

    void start() {
        System.out.println("Choose your game:\n 1.Player vs Computer\n 2.Player vs Player");
        int game = scanner.nextInt();
        if (game == 1) {
            playUserVsComputer();
        } else if (game == 2) {
            playUserVsUser();
        }
    }

    void playUserVsUser() {
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1Play();
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                exit = true;
            }

            showBoards();
            Comments.USER_2_FIELD_SELECT();
            user2Play();
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                exit = true;
            }
        }
    }

    void playUserVsComputer() {
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1Play();
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                return;
            }

            computerPlay();
            System.out.println(fieldOperator.showGameBoard());
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                return;
            }
        }
    }

    void user1Play() {
        error = false;
        do {
            int user1Field = scanner.nextInt();
            try {
                fieldOperator.selectField(user1Field, figure.getUser1Figure());
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
            int user2Field = scanner.nextInt();
            try {
                fieldOperator.selectField(user2Field, figure.getUser2Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                System.out.println("Field is occupied, try another one");
                error = true;
            }
        } while (error);
    }

    void computerPlay() {
        error = false;
        do {
            int move = random.nextInt(9+1);
            if (fieldOperator.fieldIsEmpty(move)) {
                fieldOperator.computerMove(move, figure.getUser2Figure());
                error = false;
                System.out.println("Good");
            } else {
                error = true;
                System.out.println("ERROR");
            }
        } while (error);
    }

    void showBoards() {
        System.out.println("Field numbers:\n" + board.showBoardPattern() + "\n\nCurrent Game:\n" + fieldOperator.showGameBoard());
    }
}
