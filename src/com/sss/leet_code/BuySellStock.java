package com.sss.leet_code;

public class BuySellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 1, 2, 1, 4};
        System.out.println(new BuySellStock().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
