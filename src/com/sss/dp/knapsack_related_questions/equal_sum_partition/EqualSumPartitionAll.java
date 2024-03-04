package com.sss.dp.knapsack_related_questions.equal_sum_partition;

import com.sss.dp.knapsack_related_questions.subset_sum.TopDown;

public class EqualSumPartitionAll {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // Call Subset sum with arr, arr.length and target = sum / 2;
        System.out.println(TopDown.subsetSum(nums, nums.length, sum / 2));
        // You can call recursion with memoization & top down
    }
}
