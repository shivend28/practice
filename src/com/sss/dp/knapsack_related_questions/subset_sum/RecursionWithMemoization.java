package com.sss.dp.knapsack_related_questions.subset_sum;

public class RecursionWithMemoization {
    static boolean[][] dp;

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int target = 11;
        subsetSum(arr, target);
    }

    public static void subsetSum(int[] arr, int target) {
        System.out.println(subsetSum(arr, arr.length, target));
    }

    public static boolean subsetSum(int[] arr, int n, int target) {
        if (target == 0) return true;
        if (n == 0) return false;
        if (dp[n][target]) return dp[n][target];
        if (arr[n - 1] <= target)
            return dp[n][target] = subsetSum(arr, n - 1, target) || subsetSum(arr, n - 1, target - arr[n - 1]);
        else return dp[n][target] = subsetSum(arr, n - 1, target);
    }
}
