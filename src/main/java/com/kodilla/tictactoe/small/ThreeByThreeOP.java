package com.kodilla.tictactoe.small;

import com.kodilla.tictactoe.Figure;
import com.kodilla.tictactoe.large.LargeBoardOperator;

import java.util.Random;
import java.util.Scanner;

public class ThreeByThreeOP {
    private final Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private FieldOperator fieldOperator = new FieldOperator();
    private Figure figure = new Figure();
    private Board board = new Board();
    private LargeBoardOperator largeBoardOperator = new LargeBoardOperator();

    public void startSmall() {
        fieldOperator.clearBoard();
        System.out.println("Choose your game:\n 1.Player vs Computer\n 2.Player vs Player");
        int game = scanner.nextInt();
        if (game == 1) {
            playUserVsComputerSmall();
        } else if (game == 2) {
            playUserVsUserSmall();
        }
    }

    private void playUserVsUserSmall() {
        boolean exit = false;
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1PlaySmall();
            fieldOperator.checkWinner();
            if (fieldOperator.isWin()) {
                break;
            }

            showBoards();
            Comments.USER_2_FIELD_SELECT();
            user2PlaySmall();
            fieldOperator.checkWinner();
            if (fieldOperator.isWin()) {
                break;
            }
        }
    }

    private void playUserVsComputerSmall() {
        boolean exit = false;
        figure.chooseFigure();
        while (!exit) {

            showBoards();
            Comments.USER_1_FIELD_SELECT();
            user1PlaySmall();
            fieldOperator.checkWinner();
            if (fieldOperator.isWin()) {
                break;
            }

            computerPlaySmall();
            System.out.println(fieldOperator.showGameBoard());
            fieldOperator.checkWinner();
            if (fieldOperator.isWin()) {
                break;
            }
        }
    }

    private void showBoards() {
        System.out.println("Field numbers:\n" + board.showBoardPattern() + "\n\nCurrent Game:\n" + fieldOperator.showGameBoard());
    }

    private void user1PlaySmall() {
        boolean error = false;
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

    private void user2PlaySmall() {
        boolean error = false;
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

    private void computerPlaySmall() {
        int move;
        do {
            move = random.nextInt(9 + 1);
        } while (!fieldOperator.fieldIsEmpty(move));
        fieldOperator.selectField(move, figure.getUser2Figure());
    }
}
