package dynamicproggamming.questions.advanced;

public class DistinctSubsequences {
    /**
     * https://leetcode.com/problems/distinct-subsequences/
     * rabbbit
     * rbabit
     */

    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length() + 1][t.length() + 1];

        return dfs(s, t, 0, 0, dp);
    }

    private int dfs(String s, String t, int i_s, int i_t, Integer[][] dp) {
        if (t.length() == i_t) return 1;
        if (s.length() == i_s) return 0;

        if (dp[i_s][i_t] != null) return dp[i_s][i_t];

        if (s.charAt(i_s) == t.charAt(i_t)) {
            dp[i_s][i_t] = dfs(s, t, i_s + 1, i_t + 1, dp) + dfs(s, t, i_s + 1, i_t, dp);
        } else {
            dp[i_s][i_t] = dfs(s, t, i_s + 1, i_t, dp);
        }
        return dp[i_s][i_t];
    }


}
