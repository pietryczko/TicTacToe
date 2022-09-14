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
    private int row;
    private int column;
    private final Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private FieldSelect fieldSelect = new FieldSelect();
    private Figure figure = new Figure();
    private Board board = new Board();
    private BoardOperator boardOperator = new BoardOperator();

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
            user1PlayLarge();
            boardOperator.showBoard();
            user2PlayLarge();
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
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
                exit = true;
            }

            showBoards();
            Comments.USER_2_FIELD_SELECT();
            user2PlaySmall();
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
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
            fieldSelect.checkWinner();
            if (fieldSelect.restartGame()) {
                return;
            }

            computerPlaySmall();
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

    void user1PlayLarge() {
        error = false;
        do {
            System.out.println("Select row");
            row = scanner.nextInt() - 1;
            System.out.println("Select column");
            column = scanner.nextInt() - 1;
            if (boardOperator.getField(row, column).equals("-")) {
                boardOperator.changeField(row, column, figure.getUser1Figure());
                error = false;
            } else {
                System.out.println("Field is occupied, try other");
                error = true;
            }
        } while (error);
    }

    void user2PlayLarge() {
        error = false;
        do {
            System.out.println("Select row");
            row = scanner.nextInt() - 1;
            System.out.println("Select column");
            column = scanner.nextInt() - 1;
            if (boardOperator.getField(row, column).equals("-")) {
                boardOperator.changeField(row, column, figure.getUser2Figure());
                error = false;
            } else {
                System.out.println("Field is occupied, try other");
                error = true;
            }
        } while (error);
    }

    void user1PlaySmall() {
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

    void user2PlaySmall() {
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

    void computerPlaySmall() {
        error = false;
        do {
            random.nextInt(9 + 1);
            try {
                fieldSelect.selectField(user2Field, figure.getUser2Figure());
                error = false;
            } catch (OccupiedFieldException e) {
                error = true;
            }
        } while (error);
    }
}
