package com.sss.dp.lcs_related_questions.print_lcs;

public class Recursive {
    public static void main(String[] args) {
        String x = "ABCD";
        String y = "XABYWD";
        System.out.println(lcs(x, y, x.length(), y.length()));
    }

    private static String lcs(String x, String y, int m, int n) {
        if (m == 0 | n == 0) return "";
        if (x.charAt(m - 1) == y.charAt(n - 1)) {
            return lcs(x, y, m - 1, n - 1) + x.charAt(m - 1);
        } else {
            return maxLen(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
        }
    }

    private static String maxLen(String a, String b) {
        return a.length() > b.length() ? a : b;
    }
}
