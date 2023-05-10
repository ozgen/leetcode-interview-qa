package arrays.questions.arrays.advanced;

public class MaximumSubArray {
    /**
     * https://leetcode.com/problems/maximum-subarray/description/
     */

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxS = nums[0];
        int curS = 0;

        for (int n : nums) {
            curS = Math.max(curS, 0);
            curS += n;
            maxS = Math.max(curS, maxS);
        }
        return maxS;
    }
}
