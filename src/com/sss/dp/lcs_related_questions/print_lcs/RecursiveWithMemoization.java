package com.sss.dp.lcs_related_questions.print_lcs;

import java.util.Arrays;

public class RecursiveWithMemoization {

    static String[][] dp;
    public static void main(String[] args) {
        String x = "ABCD";
        String y = "XABYWD";
        lcs(x, y);
    }

    private static void lcs(String x, String y) {
        int m = x.length(), n = y.length();
        dp = new String[m + 1][n + 1];
        for (String[] arr: dp) {
            Arrays.fill(arr, "-1");
        }
        System.out.println(lcs(x, y, m, n));
    }

    private static String lcs(String x, String y, int m, int n) {
        if (m == 0 | n == 0) return "";
        if (!dp[m][n].equals("-1")) return dp[m][n];
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return dp[m][n] = lcs(x, y, m - 1, n - 1) + x.charAt(m - 1);
        } else {
            return dp[m][n] = maxLen(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
        }
    }

    private static String maxLen(String a, String b) {
        return a.length() > b.length() ? a : b;
    }
}
