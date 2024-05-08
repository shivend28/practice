package com.sss.leet_code;

public class AllPermutation {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        permute(str, 0, n - 1);
    }

    private static void permute(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char[] charA = a.toCharArray();
        char temp = charA[i];
        charA[i] = charA[j];
        charA[j] = temp;
        return new String(charA);
    }
}
