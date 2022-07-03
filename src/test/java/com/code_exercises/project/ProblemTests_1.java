package com.code_exercises.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.SecureRandom;
import java.util.stream.LongStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.code_exercises.project.Problem_1.Statistics;
import com.google.common.math.Stats;

public class ProblemTests_1 {

    private final static long N = 1000;
    private final static long M = 1000;

    private final static double delta = 1e-3;

    private final static int rngSeed = 42;

    private final static int minRange = -100000000;
    private final static int maxRange = 100000000;

    private final SecureRandom rng = new SecureRandom();

    @BeforeEach
    void setup() {
        rng.setSeed(rngSeed);
    }

    @Test
    void testDouble() {
        LongStream.range(0, N).forEach(i -> {

            final var doubles = rng.doubles(M, minRange, maxRange).toArray();

            //System.out.println(Problem_1.toString(doubles));

            final var check = Stats.of(doubles.clone());

            final var checkMax = check.max();
            final var checkMin = check.min();
            final var checkMean = check.mean();
            final var checkStd = check.populationStandardDeviation();

            final var result = Problem_1.computeStatistics(doubles.clone());

            final var resultMax = result.get(Statistics.MAX);
            final var resultMin = result.get(Statistics.MIN);
            final var resultMean = result.get(Statistics.MEAN);
            final var resultStd = result.get(Statistics.STD);

            assertEquals(checkMax, resultMax, delta);
            assertEquals(checkMin, resultMin, delta);
            assertEquals(checkMean, resultMean, delta);
            assertEquals(checkStd, resultStd, delta);
        });
    }

    @Test
    void testInt() {

        LongStream.range(0, N).forEach(i -> {

            final var doubles = rng.ints(M, minRange, maxRange).mapToDouble(Double::valueOf).toArray();

            //System.out.println(Problem_1.toString(doubles));

            final var check = Stats.of(doubles.clone());

            final var checkMax = check.max();
            final var checkMin = check.min();
            final var checkMean = check.mean();
            final var checkStd = check.populationStandardDeviation();

            final var result = Problem_1.computeStatistics(doubles.clone());

            final var resultMax = result.get(Statistics.MAX);
            final var resultMin = result.get(Statistics.MIN);
            final var resultMean = result.get(Statistics.MEAN);
            final var resultStd = result.get(Statistics.STD);

            assertEquals(checkMax, resultMax, delta);
            assertEquals(checkMin, resultMin, delta);
            assertEquals(checkMean, resultMean, delta);
            assertEquals(checkStd, resultStd, delta);
        });
    }
}
