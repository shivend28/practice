package com.sss.dp.knapsack_related_questions.count_subset;

import java.util.Arrays;

public class RecursionWithMemoization {
    static int[][] dp;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int target = 6;
        countSubset(arr, target);
    }

    public static void countSubset(int[] arr, int target) {
        dp = new int[arr.length + 1][ target + 1];
        for (int[] n: dp) {
            Arrays.fill(n, -1);
        }
        System.out.println(countSubset(arr, arr.length, target));
    }

    private static int countSubset(int[] arr, int n, int target) {
        if (target == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][target] != -1 ) return dp[n][target];
        if (arr[n -  1] <= target)
            return countSubset(arr, n - 1, target - arr[n - 1]) + countSubset(arr, n - 1, target);
        else return countSubset(arr, n - 1, target);
    }
}
