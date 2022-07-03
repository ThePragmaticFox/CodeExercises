package com.code_exercises.project;

import java.util.Arrays;

import com.google.common.base.Objects;

public class Problem_3 {

    private Problem_3() {

    }

    public static String toString(final int[][] matrix) {
        final int n = matrix.length;
        final var builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(Arrays.stream(matrix[i]).mapToObj(String::valueOf).reduce("",
                    (x, y) -> Objects.equal(x, "") ? y : x + "," + y));
            builder.append("\n");
        }
        return builder.toString();
    }

    private static int min(final int... values) {
        if (values.length == 0) {
            return 0;
        }
        return Arrays.stream(values).reduce(values[0], Integer::min);
    }

    public static int computeAreaOfLargestSquare(final int[][] matrix, final int n, final int m) {

        // Tricky dynamic programming question.

        final var result1 = easiestDPVariant(matrix, n, m);

        // We can safe some memory by using a temporary variable.

        final var result2 = bestVariant(matrix, n, m);

        assert (result1 == result2);

        return result2;
    }

    public static int easiestDPVariant(final int[][] matrix, final int n, final int m) {

        // Runtime Complexity: O(n*m)
        // Space Complexity: O(n*m)

        var maxSide = 0;

        final var dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = matrix[i - 1][j - 1] != 1
                        ? dp[i][j]
                        : 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1], dp[i - 1][j]);
                maxSide = maxSide < dp[i][j] ? dp[i][j] : maxSide;
            }
        }

        return maxSide * maxSide;
    }

    public static int bestVariant(final int[][] matrix, final int n, final int m) {

        // Runtime Complexity: O(n*m)
        // Space Complexity: O(m)

        var maxSide = 0;

        final var dp = new int[m + 1];
        var prev = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                final var tmp = dp[j];
                dp[j] = matrix[i - 1][j - 1] != 1
                        ? 0
                        : 1 + min(dp[j - 1], dp[j], prev);
                maxSide = maxSide < dp[j] ? dp[j] : maxSide;
                prev = tmp;
            }
        }

        return maxSide * maxSide;
    }
}