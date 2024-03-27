package com.sss.dp.lcs_related_questions.print_lc_sub_string;

public class TopDown {
    public static void main(String[] args) {
        String x = "ABCDz";
        String y = "XABYWDadz";
        System.out.println(lcs(x, y, x.length(), y.length()));
    }

    private static String lcs(String x, String y, int m, int n) {
        String result = "";
        String[][] dp = new String[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = "";
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + x.charAt(i - 1);
                    result = maxLen(result, dp[i][j]);
                } else {
                    dp[i][j] = "";
                }
            }
        }
        return result;
    }
    public static String maxLen(String a, String b) {
        return a.length() > b.length() ? a : b;
    }
}
