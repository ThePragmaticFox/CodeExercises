package com.code_exercises.project;

import java.util.Arrays;
import java.util.Objects;

import com.code_exercises.project.Problem_1.Statistics;

public class Main {

    private static String HELP = "Use -h for help.";

    public static void main(String[] args) {

        if (args != null & args.length == 1 && Objects.equals(args[0], "-h")) {
            System.out.println("Example Usages: ");
            System.out.println("gradle run --args=\"Problem_1 1,2,3,4,5,6,7,8,9,10\"");
            System.out.println("gradle run --args=\"Problem_2 6.5,3.1,9.9,1.0,4\"");
            System.out.println("gradle run --args=\"Problem_3 4,4,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0\"");
            System.exit(0);
        }

        if (args == null || args.length < 2) {
            error("Missing Input.");
        }

        if (args.length > 2) {
            error("Incorrectly formated input.");
        }

        final var problem = args[0];
        final var problemInput = args[1];

        switch (problem) {
            case "Problem_1" -> problem_1(problemInput);
            case "Problem_2" -> problem_2(problemInput);
            case "Problem_3" -> problem_3(problemInput);
            default ->
                throw new IllegalStateException(String.format("The command <<%s>> is not allowed! %s", problem, HELP));
        }
    }

    private static void error(final String msg) {
        System.out.println(msg);
        System.out.println(HELP);
        System.exit(1);
    }

    private static void problem_1(final String input) {

        // I took the liberty to do it for doubles instead of integers.
        // Shouldn't be an issue in this toy case. Obviously, integers work as well.

        System.out.println(String.format("Unparsed Input: %s", input));

        // We remove unwanted input.

        final var numbers = Arrays.stream(input.split(","))
                .map(x -> Double.valueOf(x))
                .filter(Objects::nonNull)
                .filter(Double::isFinite)
                .mapToDouble(Double::doubleValue)
                .toArray();

        final var parsedInput = Problem_1.toString(numbers);

        System.out.println(String.format("Parsed Input: %s\n", parsedInput));

        System.out.println("Results on parsed input...\n");

        final var result = Problem_1.computeStatistics(numbers);

        for (final var value : Statistics.values()) {
            if (!result.containsKey(value)) {
                throw new IllegalStateException(String.format("<<%s>> is missing from the map!", value.toString()));
            }
        }

        System.out.println(String.format("Max: %f\n", result.get(Statistics.MIN)));
        System.out.println(String.format("Min: %f\n", result.get(Statistics.MAX)));
        System.out.println(String.format("Average: %f\n", result.get(Statistics.MEAN)));
        System.out.println(String.format("Std: %f", result.get(Statistics.STD)));
    }

    private static void problem_2(final String input) {

        System.out.println(String.format("Unparsed Input: %s", input));

        // We remove unwanted input.

        final var numbers = Arrays.stream(input.split(","))
                .map(x -> Double.valueOf(x))
                .filter(Objects::nonNull)
                .filter(Double::isFinite)
                .mapToDouble(Double::doubleValue)
                .toArray();

        final var parsedInput = Problem_2.toString(numbers);

        System.out.println(String.format("Parsed Input: %s\n", parsedInput));

        System.out.println("Results on parsed input...\n");

        final var sorted = Problem_2.sort(numbers);

        System.out.println(String.format("Sorted array: %s", Problem_2.toString(sorted)));
    }

    private static void problem_3(final String input) {

        System.out.println(String.format("Unparsed Input: %s", input));

        // We remove unwanted input.

        final var numbers = Arrays.stream(input.split(","))
                .map(x -> Integer.valueOf(x))
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();

        if (numbers.length < 2) {
            error("Wrong format.");
        }

        final var n = (int) numbers[0];
        final var m = (int) numbers[1];

        if (n <= 0 || m <= 0) {
            error("n and m must be each > 0.");
        }

        if (n * m != numbers.length - 2) {
            error("The parsed matrix is not of size n*m.");
        }

        final var matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final var val = numbers[2 + i * n + j];
                if (val != 0 && val != 1) {
                    error("Matrix should not contain any other values than 0 or 1.");
                }
                matrix[i][j] = val;
            }
        }

        final var parsedInput = Problem_3.toString(matrix);

        System.out.println(String.format("Parsed Input: %s\n", parsedInput));

        System.out.println("Results on parsed input...\n");

        final var area = Problem_3.computeAreaOfLargestSquare(matrix, n, m);

        System.out.println(String.format("Area of largest square %s", area));
    }
}
