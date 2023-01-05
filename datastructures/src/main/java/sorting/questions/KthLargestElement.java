package sorting.questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    /**
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     */
    public static int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        if (length < k || length == 0) return 0;
        if (length == 1 && k == 1) return nums[0];
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            nums[i] = minHeap.poll();
        }
        return (int) nums[length - k];
    }

    public int findKthLargest3(int[] nums, int k) {
        //create a min heap
        PriorityQueue<Integer> heap = new PriorityQueue();

        //iterate over the array
        for (int n : nums) {
            //first add the integer to heap
            heap.add(n);
            //if size of the heap is greater than k
            if (heap.size() > k) {
                //remove the root element (lowest of all)
                heap.poll();
            }
        }
        //finally heap has k largest elements left with root as the kth largest element
        return heap.peek();
    }

    // quick-sort solution
    public static int findKthLargest2(int[] nums, int k) {
        int length = nums.length - 1;
        if (length < k || length == 0) return 0;
        if (length == 1 && k == 1) return nums[0];

        return quickSort(nums, 0, length, k);

    }

    public static int quickSort(int[] nums, int start, int end, int k) {
        int pivot = nums[end];
        int left = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int tmp = nums[left];
                nums[left] = nums[i];
                nums[i] = tmp;
                left++;
            }
        }

        // Move pivot in-between left & right sides
        nums[end] = nums[left];
        nums[left] = pivot;

        if (left < k) {
            quickSort(nums, left + 1, end, k);
        } else if (left > k) {
            quickSort(nums, start, left - 1, k);
        } else {
            return pivot;
        }
        return nums[nums.length - k];
    }


    public static void main(String[] args) {
        int [] arr = new int[]{3,2,1,5,3,5,6,9,5,7};
        System.out.println(findKthLargest(arr, 2));
        System.out.println(findKthLargest2(arr, 2));
    }
}
