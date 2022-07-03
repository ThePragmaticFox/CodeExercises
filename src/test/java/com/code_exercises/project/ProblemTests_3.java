package com.code_exercises.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProblemTests_3 {

    @Test
    void test_1() {

        final var n = 1;
        final var m = 1;

        final int[][] matrix = { { 0 } };

        final int checkArea = 0;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_2() {

        final var n = 1;
        final var m = 1;

        final int[][] matrix = { { 1 } };

        final int checkArea = 1;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_3() {

        final var n = 4;
        final var m = 4;

        final int[][] matrix = {
                { 1, 0, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 1 } };

        final int checkArea = 4;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_4() {

        final var n = 4;
        final var m = 4;

        final int[][] matrix = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };

        final int checkArea = 1;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_5() {

        final var n = 4;
        final var m = 4;

        final int[][] matrix = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        final int checkArea = 0;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_6() {

        final var n = 5;
        final var m = 5;

        final int[][] matrix = {
                { 1, 1, 1, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0 },
                { 1, 1, 0, 1, 0 }
        };

        final int checkArea = 4;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_7() {

        final var n = 5;
        final var m = 5;

        final int[][] matrix = {
                { 0, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 }
        };

        final int checkArea = 9;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_8() {

        final var n = 5;
        final var m = 5;

        final int[][] matrix = {
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 }
        };

        final int checkArea = 25;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_9() {

        final var n = 5;
        final var m = 4;

        final int[][] matrix = {
                { 0, 0, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };

        final int checkArea = 4;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_10() {

        final var n = 5;
        final var m = 4;

        final int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };

        final int checkArea = 16;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_11() {

        final var n = 5;
        final var m = 4;

        final int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 0 }
        };

        final int checkArea = 9;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }

    @Test
    void test_12() {

        final var n = 5;
        final var m = 4;

        final int[][] matrix = {
                { 1, 0, 1, 1 },
                { 1, 0, 1, 0 },
                { 1, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 1, 0, 0, 0 }
        };

        final int checkArea = 1;
        final var resultArea = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        assertEquals(checkArea, resultArea);
    }
}
