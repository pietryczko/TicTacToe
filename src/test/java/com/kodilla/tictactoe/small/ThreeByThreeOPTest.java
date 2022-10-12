package com.kodilla.tictactoe.small;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeByThreeOPTest {
    private final FieldOperator fieldOperator = new FieldOperator();

    @Nested
    @DisplayName("Test all horizontal and vertical variants with O")
    class TestOVariants {
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
            assertTrue(result);
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
            assertTrue(result);
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
            assertTrue(result);
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
            assertTrue(result);
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
            assertTrue(result);
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
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Test horizontal and vertical variants with X")
    class TestXVariants {
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
            assertTrue(result);
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

            assertTrue(result);
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
            assertTrue(result);
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
            assertTrue(result);
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
            assertTrue(result);
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

            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Test cross variants with X")
    class TestXCrossVariants {
        @Test
        void testXCross1() {
            //Given
            fieldOperator.selectField(1, "X");
            fieldOperator.selectField(5, "X");
            fieldOperator.selectField(9, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertTrue(result);
        }

        @Test
        void testXCross2() {
            //Given
            fieldOperator.selectField(3, "X");
            fieldOperator.selectField(5, "X");
            fieldOperator.selectField(7, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Test cross variants with O")
    class TestOCrossVariants {
        @Test
        void testOCross1() {
            //Given
            fieldOperator.selectField(1, "O");
            fieldOperator.selectField(5, "O");
            fieldOperator.selectField(9, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then

            assertTrue(result);
        }

        @Test
        void testOCross2() {
            //Given
            fieldOperator.selectField(3, "O");
            fieldOperator.selectField(5, "O");
            fieldOperator.selectField(7, "O");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isWin();

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Testing draw variant")
    class TestDraw {
        @Test
        void testDraw() {
            //Given
            fieldOperator.selectField(1, "O");
            fieldOperator.selectField(2, "X");
            fieldOperator.selectField(3, "O");
            fieldOperator.selectField(4, "O");
            fieldOperator.selectField(5, "X");
            fieldOperator.selectField(6, "O");
            fieldOperator.selectField(7, "X");
            fieldOperator.selectField(8, "O");
            fieldOperator.selectField(9, "X");
            fieldOperator.checkWinner();

            //When
            boolean result = fieldOperator.isDraw();

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Testing Occupied Field Exception")
    class SuffixTest {
        @Test
                ()
        void testOccupiedFieldException() {
            //Given
            fieldOperator.selectField(1, "X");

            //Then
            assertThrows(OccupiedFieldException.class, () -> fieldOperator.selectField(1, "X"));
        }
    }
}