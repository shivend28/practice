package com.sss.dp.lcs_related_questions.lc_sub_string;

public class TopDown {
    public static void main(String[] args) {
        String x = "ABC";
        String y = "ABDC";
        System.out.println(lcs(x, y, x.length(), y.length()));
    }

    private static int lcs(String x, String y, int m, int n) {
        int result = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
}
