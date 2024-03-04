package com.sss.dp.knapsack_related_questions.number_of_subsets;

import com.sss.dp.knapsack_related_questions.count_subset.RecursionWithMemoization;
import com.sss.dp.knapsack_related_questions.count_subset.Recursive;
import com.sss.dp.knapsack_related_questions.count_subset.TopDown;

public class NumberOfSubsetsAll {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2};
        int diff = 1;
        numberOfSubset(arr, diff);
    }
    /*
        s1 - s2 = diff
        s1 + s2 = sum
   -----------------------
            s1 = (diff + sum) / 2  =>    sum - (sum - diff) / 2;
            call countSubset(arr, (diff + sum) /2)
     */

    private static void numberOfSubset(int[] arr, int diff) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        int target = sum - (sum - diff) / 2;
        // call
        System.out.println(TopDown.countSubset(arr, arr.length, target));
        System.out.println(Recursive.countSubset(arr, arr.length, target));
        RecursionWithMemoization.countSubset(arr, target);
    }
}
