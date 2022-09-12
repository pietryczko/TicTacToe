package com.kodilla.tictactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeRunner {
    private boolean exit = false;
    private boolean error;
    private int game;
    private int user1Field;
    private int user2Field;
    private final Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private FieldSelect fieldSelect = new FieldSelect();
    private Figure figure = new Figure();
    private Board board = new Board();

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeRunner.class, args);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
        ticTacToeRunner.start();
    }

    void start() {
        System.out.println("Choose your game:\n 1.Player vs Computer\n 2.Player vs Player");
        game = scanner.nextInt();
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
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
                return;
            }

            showBoards();
            Comments.USER_2_FIELD_SELECT();
            user2Play();
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
                return;
            }
        }
    }

    void playUserVsComputer() {
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1Play();
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
                return;
            }

            computerPlay();
            System.out.println(fieldSelect.showGameBoard());
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
                return;
            }
        }
    }

    void showBoards() {
        System.out.println("Field numbers:\n" + board.showBoardPattern() + "\n\nCurrent Game:\n" + fieldSelect.showGameBoard());
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

    void computerPlay() {
        error = false;
        do {
            int move = random.nextInt(9 + 1);
            try {
                fieldSelect.selectField(move, figure.getUser2Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                error = true;
            }
        } while (error);
    }
}
