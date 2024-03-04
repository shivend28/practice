package com.sss.dp.knapsack_related_questions.count_subset;

public class Recursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        int target = 6;
        System.out.println(countSubset(arr, arr.length, target));
    }

    public static int countSubset(int[] arr, int n, int target) {
        if (target == 0) return 1;
        if (n == 0) return 0;
        if (arr[n -  1] <= target)
            return countSubset(arr, n - 1, target - arr[n - 1]) + countSubset(arr, n - 1, target);
        else return countSubset(arr, n - 1, target);
    }
}
