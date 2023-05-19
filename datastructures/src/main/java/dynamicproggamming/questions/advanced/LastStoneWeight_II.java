package dynamicproggamming.questions.advanced;

public class LastStoneWeight_II {
    /**
     * https://leetcode.com/problems/last-stone-weight-ii/
     */


    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;

        Integer[][] dp = new Integer[stones.length][sum];
        return helper(stones, 0, 0, 0, dp);
    }

    private int helper(int[] stones, int idx, int sumL, int sumR, Integer[][] dp) {
        if (idx == stones.length) {
            return Math.abs(sumL - sumR);
        }

        if (dp[idx][sumL] != null) return dp[idx][sumL];

        int addedLeft = helper(stones, idx + 1, sumL + stones[idx], sumR, dp);
        int addedRight = helper(stones, idx + 1, sumL, sumR + stones[idx], dp);
        dp[idx][sumL] = Math.min(addedLeft, addedRight);
        return dp[idx][sumL];
    }
}
