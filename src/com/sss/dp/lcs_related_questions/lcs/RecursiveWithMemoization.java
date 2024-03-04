package com.sss.dp.lcs_related_questions.lcs;

import java.util.Arrays;

public class RecursiveWithMemoization {

    static int[][] dp;
    public static void main(String[] args) {
        String x = "ABCD";
        String y = "XABYWD";
        lcs(x, y);
    }

    private static void lcs(String x, String y) {
        int m = x.length(), n = y.length();
        dp = new int[m + 1][n + 1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(lcs(x, y, m, n));
    }

    private static int lcs(String x, String y, int m, int n) {
        if (m == 0 | n == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return dp[m][n] = 1 + lcs(x, y, m - 1, n - 1);
        } else {
            return dp[m][n] = Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
        }
    }
}
