package com.sss.dp.knapsack.subset_sum;

public class Recursion {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7};
        int target = 15;
        System.out.println(subsetSum(arr, arr.length, target));
    }

    public static boolean subsetSum(int[] arr, int n, int target) {
        if (target == 0) return true;
        if (n == 0) return false;
        if (arr[n - 1] <= target) return subsetSum(arr, n - 1, target) || subsetSum(arr, n - 1, target - arr[n - 1]);
        else return subsetSum(arr, n - 1, target);
    }
}
