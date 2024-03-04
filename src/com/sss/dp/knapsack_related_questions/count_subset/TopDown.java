package com.sss.dp.knapsack_related_questions.count_subset;

public class TopDown {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int target = 6;
        System.out.println(countSubset(arr, arr.length, target));
    }

    public static int countSubset(int[] arr, int n, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i < target + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][target];
    }


}
