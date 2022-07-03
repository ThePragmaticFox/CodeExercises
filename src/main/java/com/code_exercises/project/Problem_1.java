package com.code_exercises.project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Problem_1 {

    private Problem_1() {

    }

    public static String toString(final double[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).reduce("",
                (x, y) -> Objects.equal(x, "") ? y : x + "," + y);
    }

    public static Map<Statistics, Double> computeStatistics(final double[] numbers) {

        if (numbers.length == 0) {
            return Map.of(Statistics.MAX, 0.0,
                    Statistics.MIN, 0.0,
                    Statistics.MEAN, 0.0,
                    Statistics.STD, 0.0);
        }

        final var max = getMax(numbers);
        final var min = getMin(numbers);
        final var mean = getMean(numbers);
        final var std = getStd(numbers, mean);

        final var results = new HashMap<Statistics, Double>();

        results.put(Statistics.MAX, max);
        results.put(Statistics.MIN, min);
        results.put(Statistics.MEAN, mean);
        results.put(Statistics.STD, std);

        return results;
    }

    private static double getMax(final double[] numbers) {
        final var maxVal = Arrays.stream(numbers).reduce(numbers[0], Double::max);
        return maxVal;
    }

    private static double getMin(final double[] numbers) {
        final var minVal = Arrays.stream(numbers).reduce(numbers[0], Double::min);
        return minVal;
    }

    private static double getMean(final double[] numbers) {
        final var meanVal = Arrays.stream(numbers).reduce(0.0, (x, y) -> x + y) / Double.valueOf(numbers.length);
        return meanVal;
    }

    private static double getStd(final double[] numbers, final double mean) {
        // We compute the uncorrected sample standard deviation.
        if (numbers.length == 1) {
            return 0.0;
        }
        final var sumOfSquares = Arrays.stream(numbers).map(Double::valueOf).reduce(0.0,
                (x, y) -> x + Math.pow(y - mean, 2));
        final var meanSumOfSquares = sumOfSquares / Double.valueOf(numbers.length);
        final var stdVal = Math.sqrt(meanSumOfSquares);
        return stdVal;
    }

    public enum Statistics {
        MIN("min"),
        MAX("max"),
        MEAN("mean"),
        STD("std");

        private final String name;

        private Statistics(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}