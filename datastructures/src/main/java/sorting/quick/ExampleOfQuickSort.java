package sorting.quick;

import java.util.Arrays;

public class ExampleOfQuickSort {

    public static int[] quickSort(int[] arr, int start, int end) {
        if (arr.length <= 1 || end - start + 1 <= 1) return arr;


        int pivot = arr[end];

        int left = start;       // pointer for left side

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[left];
                arr[left] = arr[i];
                arr[i] = tmp;
                left++;
            }
        }

        // swap pivot
        arr[end] = arr[left];
        arr[left] = pivot;
        // Quick sort left side
        quickSort(arr, start, left - 1);

        // Quick sort right side
        quickSort(arr, left + 1, end);
        return  arr;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{3,2,1,5,3,5,6,9,5,7};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
