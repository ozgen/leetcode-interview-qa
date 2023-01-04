package sorting.questions;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-an-array/description/
 */
public class SortArray {

    // time limit exceed - insertion sort
    public int[] sortArray1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;

            while (j >= 0 && nums[j + 1] < nums[j]) {
                int tmp = nums[j + 1];
                nums[j + 1] = nums[j];
                nums[j] = tmp;
                j -= 1;
            }
        }
        return nums;
    }

    // merge sort
    public int[] sortArray(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        return mergeSort(nums, l, r);
    }

    public int[] mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
        return arr;
    }

    public void merge(int[] arr, int l, int m, int r) {
        int length1 = m - l + 1;
        int length2 = r - m;

        int L[] = new int[length1];
        int R[] = new int[length2];

        for (int i = 0; i < length1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < length2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0; // index for left
        int j = 0; // index for right
        int k = l; // Initial index of merged subarray array
        while (i < length1 && j < length2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < length1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < length2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 3, 1};
        SortArray sortArray = new SortArray();
        int[] sortedArr = sortArray.sortArray1(arr);
        int[] sortedArr2 = sortArray.sortArray(arr);
        Arrays.stream(sortedArr).forEach(System.out::println);

        System.out.println("-------------------");
        Arrays.stream(sortedArr2).forEach(System.out::println);

    }
}
