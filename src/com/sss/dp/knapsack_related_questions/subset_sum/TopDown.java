package com.sss.dp.knapsack_related_questions.subset_sum;

public class TopDown {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int target = 11;
        System.out.println(subsetSum(arr, arr.length, target));
    }

    public static boolean subsetSum(int[] arr, int n, int target) {
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 1; i < target + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
