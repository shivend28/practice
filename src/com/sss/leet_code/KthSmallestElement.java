package com.sss.leet_code;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {2, 10, 9, 3, 1, 5};
        System.out.println(kthSmallestElement(arr, k));
        System.out.println(kthLargestElement(arr, k));

    }

    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
        for (int element: arr) {
            if (q.size() > k) {
                q.poll();
            }
            q.add(element);
        }
        return q.peek() == null ? -1 : q.peek();
    }

    private static int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int element: arr) {
            if (q.size() > k) {
                q.poll();
            }
            q.add(element);
        }
        return q.peek() == null ? -1 : q.peek();
    }

}
