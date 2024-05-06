package com.sss.leet_code;

import java.util.Arrays;

public class PivotalPartitioning {
    /*
            Using Same Array
            arr = 1, 4, 5, 9, 2, 6, 8
            k = 5

            o/p = 1, 4, 2, 5, 9, 6, 8

     */


    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 9, 2, 6, 8};
        int n = arr.length;
        int k = 5;
        int[] result = soln(arr, n, k);
        System.out.println(Arrays.toString(result));
    }

    private static int[] soln(int[] arr, int n, int k) {
        int indexOfK = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                indexOfK = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i > indexOfK && arr[i] <= arr[indexOfK]) {
                int temp = arr[i];
                for (int j = i; j >= indexOfK ; j--) {
                    if (j == indexOfK) {
                        arr[indexOfK] = temp;
                        indexOfK = j + 1;
                    } else {
                        arr[j] = arr[j - 1];
                    }
                }

            } else if (i < indexOfK && arr[i] > arr[indexOfK]) {
                for (int j = indexOfK; j >= i ; j--) {
                    if (j == i) {
                        arr[i] = k;
                    } else {
                        arr[j] = arr[j - 1];
                    }
                }
                indexOfK = i;
            }

        }
        return arr;
    }
}
