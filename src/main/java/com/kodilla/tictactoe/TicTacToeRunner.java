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
    private int gameMode;
    private int user1Field;
    private int user2Field;
    private final Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private FieldOperator fieldOperator = new FieldOperator();
    private Figure figure = new Figure();
    private Board board = new Board();
    private LargeBoardOperator boardOperator = new LargeBoardOperator();

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeRunner.class, args);
        TicTacToeRunner ticTacToeRunner = new TicTacToeRunner();
        ticTacToeRunner.startGame();
    }

    void startGame() {
        System.out.println("Press 1 to play small Tic Tac Toe\nPress 2 to play large Tic Tac Toe");
        gameMode = scanner.nextInt();
        if (gameMode == 1) {
            startSmall();
        } else if (gameMode == 2) {
            startLarge();
        }
    }

    void startLarge() {
        boardOperator.createBoard();
        figure.chooseFigure();
        while (!exit) {
            boardOperator.showBoard();
            boardOperator.chooseField(figure.getUser1Figure());
            boardOperator.showBoard();
            boardOperator.chooseField(figure.getUser2Figure());
        }
    }

    void startSmall() {
        System.out.println("Choose your game:\n 1.Player vs Computer\n 2.Player vs Player");
        game = scanner.nextInt();
        if (game == 1) {
            playUserVsComputerSmall();
        } else if (game == 2) {
            playUserVsUserSmall();
        }
    }

    void playUserVsUserSmall() {
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1PlaySmall();
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                exit = true;
            }

            showBoards();
            Comments.USER_2_FIELD_SELECT();
            user2PlaySmall();
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                exit = true;
            }
        }
    }

    void playUserVsComputerSmall() {
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1PlaySmall();
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                return;
            }

            computerPlaySmall();
            System.out.println(fieldOperator.showGameBoard());
            fieldOperator.checkWinner();
            if (fieldOperator.restartGame()) {
                return;
            }
        }
    }

    void showBoards() {
        System.out.println("Field numbers:\n" + board.showBoardPattern() + "\n\nCurrent Game:\n" + fieldOperator.showGameBoard());
    }

    void user1PlaySmall() {
        error = false;
        do {
            user1Field = scanner.nextInt();
            try {
                fieldOperator.selectField(user1Field, figure.getUser1Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                System.out.println("Field is occupied, try another one");
                error = true;
            }
        } while (error);
    }

    void user2PlaySmall() {
        error = false;
        do {
            user2Field = scanner.nextInt();
            try {
                fieldOperator.selectField(user2Field, figure.getUser2Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                System.out.println("Field is occupied, try another one");
                error = true;
            }
        } while (error);
    }

    void computerPlaySmall() {
        int move;
            do {
                move = random.nextInt(9 + 1);
            } while (!fieldOperator.fieldIsEmpty(move));
        fieldOperator.selectField(move, figure.getUser2Figure());
        }
    }
