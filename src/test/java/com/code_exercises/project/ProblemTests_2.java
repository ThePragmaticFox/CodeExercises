package com.code_exercises.project;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.LongStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProblemTests_2 {

    private final static long N = 1000;
    private final static long M = 1000;

    private final static int rngSeed = 42;

    private final static int minRange = -100000000;
    private final static int maxRange = 100000000;

    private final SecureRandom rng = new SecureRandom();

    @BeforeEach
    void setup() {
        rng.setSeed(rngSeed);
    }

    @Test
    void test() {
        LongStream.range(0, N).forEach(i -> {
            final var doubles = rng.doubles(M, minRange, maxRange).toArray();
            final var resultSorted = Problem_2.sort(doubles.clone());
            final var checkSorted = doubles.clone();
            Arrays.sort(checkSorted);
            assertArrayEquals(resultSorted, checkSorted);
        });
    }
}
