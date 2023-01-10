package binarysearch.questions;

public class BinarySearch {
    /**
     * https://leetcode.com/problems/binary-search/
     */

    public int search(int[] nums, int target) {
        int L = 0;
        int H = nums.length - 1;
        int m;

        while (L <= H) {
            m = (L + H) / 2;
            if (target > nums[m]) {
                L = m + 1;
            } else if (target < nums[m]) {
                H = m - 1;
            } else {
                return m;
            }

        }
        return -1;
    }
}
