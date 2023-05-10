package arrays.questions.arrays.advanced;

public class MaximumSumCircularSubArray {
    /**
     * https://leetcode.com/problems/maximum-sum-circular-subarray/
     */

    public int maxSubarraySumCircular(int[] nums) {
        int minG = nums[0];
        int maxG = nums[0];
        int minC = 0;
        int maxC = 0;
        int total = 0;

        for (int n : nums) {
            maxC = Math.max(maxC + n, n);
            minC = Math.min(minC + n, n);
            total += n;
            maxG = Math.max(maxG, maxC);
            minG = Math.min(minG, minC);
        }
        return maxG > 0 ? Math.max(maxG, total - minG) : maxG;
    }
}
