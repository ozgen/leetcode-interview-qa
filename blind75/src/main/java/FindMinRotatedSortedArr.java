public class FindMinRotatedSortedArr {
    /**
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     */
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }
            int m = (l + r) / 2;
            if (nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return 0;
    }
}
