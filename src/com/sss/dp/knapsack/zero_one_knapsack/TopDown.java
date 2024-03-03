package com.sss.dp.knapsack.zero_one_knapsack;

public class TopDown {

    public static void main(String[] args) {
        int[] wt = {1, 2, 5};
        int[] val = {1, 2, 5};
        int w = 7;
        System.out.println(topDownDP(wt, val, w, wt.length));
    }

    private static int topDownDP(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }

}
