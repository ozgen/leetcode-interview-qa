package dynamicproggamming.questions;

public class HouseRobber {
    /**
     * https://leetcode.com/problems/house-robber/
     */

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int rob1 = 0;
        int rob2 = 0;
        for (int n : nums) {
            int tmp = Math.max(rob2, rob1 + n);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }


    public int robDp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i ++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
}
