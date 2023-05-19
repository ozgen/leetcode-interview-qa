package dynamicproggamming.questions.advanced;

public class MincostTickets {

    /**
     * https://leetcode.com/problems/minimum-cost-for-tickets/
     */

    public int mincostTickets(int[] days, int[] costs) {
        Integer[] dp = new Integer[days.length];
        int[] dayValue = new int[]{1, 7, 30};
        return dfs(days, dayValue, costs, dp, 0);
    }

    private int dfs(int[] days, int[] dayValue, int[] costs, Integer[] dp, int i) {
        if (i == days.length) return 0;

        if (dp[i] != null) return dp[i];

        dp[i] = Integer.MAX_VALUE;

        for (int j = 0; j < costs.length; j++) {
            int tmp = i;
            while (tmp < days.length && days[tmp] < days[i] + dayValue[j]) {
                tmp += 1;
            }
            dp[i] = Math.min(dp[i], costs[j] + dfs(days, dayValue, costs, dp, tmp));
        }
        return dp[i];
    }
}
