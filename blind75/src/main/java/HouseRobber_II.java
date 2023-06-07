public class HouseRobber_II {

    /**
     * https://leetcode.com/problems/house-robber-ii/
     */

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        return Math.max(
                robHelper(nums, 0, len - 2),
                robHelper(nums, 1, len - 1)
        );
    }

    private int robHelper(int[] n, int s, int e) {
        int r1 = 0;
        int r2 = 0;

        for (int i = s; i <= e; i++) {
            int max = Math.max(r1 + n[i], r2);
            r1 = r2;
            r2 = max;
        }
        return r2;
    }
}
