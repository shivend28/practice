package com.sss.leet_code;

public class PivotalPartitioning {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 2, 3, 4};
        //pivotalPartitioning(arr, 0, arr.length, 3);
        partition(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void pivotArray(int[] nums, int pivot) {
        int pivotCount = 0, low = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                swapII(nums, low++, i);
            } else if (nums[i] == pivot) {
                swapII(nums, low + pivotCount++, i);
            }
        }
    }
    private static void swapII(int[] nums, int l, int r) {
        if (l == r) return;
        int n = nums[r];
        for (int i = r - 1; i >= l; i--) {
            nums[i + 1] = nums[i];
        }
        nums[l] = n;
    }

    static int partition(int[] a){
        int pivot = 4;
        int temp, index = 0;
        int last = a.length -1;

        for(int i = 1; i < a.length; i++){
            if( a[i] <= pivot){
                temp = a[i];
                a[i] = pivot;
                a[i-1] = temp;
                index = i;
            } else if( a[i] > pivot && last > i){
                temp = a[i];
                a[i] = a[last];
                a[last] = temp;
                last -= 1;
                i--;
            }
            else
                break;
        }
        return index;
    }
    private static void pivotalPartitioning(int[] arr, int low, int high, int pivotal) {
        int i = low - 1;
        int firstMaxIndex = 0;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivotal) {
                swap(arr, ++i, j);
            } else {

            }
        }
        swap(arr, ++i, high - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
