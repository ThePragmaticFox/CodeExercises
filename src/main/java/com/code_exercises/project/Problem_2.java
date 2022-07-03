package com.code_exercises.project;

import java.util.Arrays;

import com.google.common.base.Objects;

public class Problem_2 {

    private Problem_2() {

    }

    public static String toString(final double[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).reduce("",
                (x, y) -> Objects.equal(x, "") ? y : x + "," + y);
    }

    public static double[] sort(final double[] unsorted) {
        final var sorted = unsorted.clone();
        mergeSort(sorted, sorted.length);
        return sorted;
    }

    private static void mergeSort(final double[] array, final int n) {

        // Runtime Complexity: O(nlogn)
        // Space Complexity: O(n)

        if (n <= 1) {
            return;
        }

        final var mid = n / 2;

        final var l = mid;
        final var r = n - mid;

        final var left = new double[l];
        final var right = new double[r];

        for (int i = 0; i < l; i++) {
            left[i] = array[i];
        }

        for (int i = l; i < n; i++) {
            right[i - l] = array[i];
        }

        mergeSort(left, l);
        mergeSort(right, r);

        merge(array, left, right, l, r);
    }

    private static void merge(final double[] array, final double[] left, final double[] right, final int l,
            final int r) {
        var i = 0;
        var j = 0;
        var a = 0;
        while (i < l && j < r) {
            if (left[i] <= right[j]) {
                array[a] = left[i];
                i++;
            } else {
                array[a] = right[j];
                j++;
            }
            a++;
        }
        while (i < l) {
            array[a] = left[i];
            i++;
            a++;
        }
        while (j < r) {
            array[a] = right[j];
            j++;
            a++;
        }
    }
}
