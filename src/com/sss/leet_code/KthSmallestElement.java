package com.sss.leet_code;

import java.util.*;

public class KthSmallestElement {
    public static void main(String[] args) {
        int k = 3;
        Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 10, 7, 9, 8 };
        System.out.println(kthSmallestElement(List.of(arr), k));
        //System.out.println(kthSmallestElementInStream(List.of(arr), k));
        // System.out.println(kthLargestElement(arr, k));

    }

    private static int kthSmallestElement(List<Integer> arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
        for (int element: arr) {
            q.offer(element);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek() == null ? -1 : q.peek();
    }

    private static List<Integer> kthSmallestElementInStream(List<Integer> arr, int k) {
        List<Integer> allKthElement = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
        for (int element: arr) {

            if (q.size() < k) {
                q.add(element);
            } else {
                if (element > q.peek()) {
                    q.poll();
                    q.add(element);
                }
            }
            if (q.size() >= k) {
                allKthElement.add(q.peek());
            } else {
                allKthElement.add(-1);
            }
        }
        return allKthElement;
    }

    private static int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int element: arr) {
            if (q.size() > k ) {
                q.poll();
            }
            q.add(element);
        }
        System.out.println(q);
        return q.peek() == null ? -1 : q.peek();
    }

}
