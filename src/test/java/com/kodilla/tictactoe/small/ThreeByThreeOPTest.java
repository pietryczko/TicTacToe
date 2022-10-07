package com.kodilla.tictactoe.small;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeByThreeOPTest {
    private FieldOperator fieldOperator = new FieldOperator();

    @Nested
    @DisplayName("Test all variants with O")
    class testOVariants {
        @Test
        void testLeftVerticalO() {
            //Given
            fieldOperator.selectField(1, "O");
            fieldOperator.selectField(4, "O");
            fieldOperator.selectField(7, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testMiddleVerticalO() {
            //Given
            fieldOperator.selectField(2, "O");
            fieldOperator.selectField(5, "O");
            fieldOperator.selectField(8, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testVerticalRightO() {
            //Given
            fieldOperator.selectField(3, "O");
            fieldOperator.selectField(6, "O");
            fieldOperator.selectField(9, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testTopHorizontalO() {
            //Given
            fieldOperator.selectField(1, "O");
            fieldOperator.selectField(2, "O");
            fieldOperator.selectField(3, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testMiddleHorizontalO() {
            //Given
            fieldOperator.selectField(4, "O");
            fieldOperator.selectField(5, "O");
            fieldOperator.selectField(6, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testDownHorizontalO() {
            //Given
            fieldOperator.selectField(7, "O");
            fieldOperator.selectField(8, "O");
            fieldOperator.selectField(9, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }
    }

    @Nested
    @DisplayName("Test all variants with X")
    class testXVariants {
        @Test
        void testLeftVerticalX() {
            //Given
            fieldOperator.selectField(1, "X");
            fieldOperator.selectField(4, "X");
            fieldOperator.selectField(7, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testMiddleVerticalX() {
            //Given
            fieldOperator.selectField(2, "X");
            fieldOperator.selectField(5, "X");
            fieldOperator.selectField(8, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testVerticalRightX() {
            //Given
            fieldOperator.selectField(3, "X");
            fieldOperator.selectField(6, "X");
            fieldOperator.selectField(9, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testTopHorizontalX() {
            //Given
            fieldOperator.selectField(1, "X");
            fieldOperator.selectField(2, "X");
            fieldOperator.selectField(3, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testMiddleHorizontalX() {
            //Given
            fieldOperator.selectField(4, "X");
            fieldOperator.selectField(5, "X");
            fieldOperator.selectField(6, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }

        @Test
        void testDownHorizontalX() {
            //Given
            fieldOperator.selectField(7, "X");
            fieldOperator.selectField(8, "X");
            fieldOperator.selectField(9, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertEquals(true, result);
        }
    }
}