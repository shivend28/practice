package com.sss.leet_code;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArraysWithKDistinct {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 3;
        System.out.println(subArraysWithKDistinct(arr, k));
    }

    public static ArrayList<Integer> subArraysWithKDistinct(int[] arr, int K) {
        int n = arr.length;
        int start = 0;
        int end = n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            j++;
            while (map.size() == K) {
                if (j - 1 - i < end - start) {
                    start = i;
                    end = j - 1;
                }
                // Remove elements from left
                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
                i++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (end == n) {
            ans.add(-1);
        } else {
            ans.add(start);
            ans.add(end);
        }

        return ans;
    }
}

