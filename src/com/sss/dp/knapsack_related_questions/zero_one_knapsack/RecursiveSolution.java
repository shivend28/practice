package com.sss.dp.knapsack_related_questions.zero_one_knapsack;

public class RecursiveSolution {
    public static void main(String[] args) {
        int[] wt = {1, 2, 5};
        int[] val = {1, 2, 5};
        int w = 7;
        System.out.println(recursive(wt, val, w, wt.length));
    }

    private static int recursive(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) return 0;
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + recursive(wt, val, w - wt[n - 1], n - 1), recursive(wt, val, w, n - 1));
        } else {
            return recursive(wt, val, w, n - 1);
        }
    }
}
