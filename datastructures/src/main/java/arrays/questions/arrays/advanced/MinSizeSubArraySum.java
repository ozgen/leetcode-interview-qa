package arrays.questions.arrays.advanced;

public class MinSizeSubArraySum {
    /**
     * https://leetcode.com/problems/minimum-size-subarray-sum/
     */

    public int minSubArrayLen(int target, int[] nums) {

        int res = Integer.MAX_VALUE;
        int l = 0;
        int total = 0;
        for (int r = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                res = Math.min(res, r - l + 1);
                total -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
