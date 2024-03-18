package com.sss.leet_code;

public class Sort01And2 {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int n = arr.length;
        sortArr(arr, n);
    }

    private static void sortArr(int[] arr, int n) {
        for (int a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) zero++;
            else if (arr[i] == 1) one++;
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 <= zero) arr[i] = 0;
            else if (i + 1 <= zero + one) arr[i] = 1;
            else arr[i] = 2;
        }
        for (int a: arr) {
            System.out.print(a + " ");
        }
    }
}
