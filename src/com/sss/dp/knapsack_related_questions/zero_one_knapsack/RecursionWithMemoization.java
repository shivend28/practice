package com.sss.dp.knapsack_related_questions.zero_one_knapsack;

import java.util.Arrays;

public class RecursionWithMemoization {
    static int[][] dp;
    public static void main(String[] args) {
        int[] wt = {1, 2, 5};
        int[] val = {1, 2, 5};
        int w = 7;
        dp = new int[wt.length + 1][w + 1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(recursive(wt, val, w, wt.length));
    }


    private static int recursive(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) return 0;
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + recursive(wt, val, w - wt[n - 1], n - 1), recursive(wt, val, w, n - 1));
        } else {
            return dp[n][w] = recursive(wt, val, w, n - 1);
        }
    }
}
