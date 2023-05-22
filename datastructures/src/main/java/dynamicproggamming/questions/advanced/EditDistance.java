package dynamicproggamming.questions.advanced;

public class EditDistance {
    /**
     * https://leetcode.com/problems/edit-distance/
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer[][] dp = new Integer[m + 1][n + 1];
        return dfs(word1, word2, m, n, dp);
    }

    private int dfs(String w1, String w2, int i1, int i2, Integer[][] dp) {
        if (i1 == 0 && i2 == 0) return 0;
        if (i1 == 0 || i2 == 0) return Math.max(i1, i2);

        if (dp[i1][i2] != null) return dp[i1][i2];

        if (w1.charAt(i1 - 1) == w2.charAt(i2 - 1)) {
            dp[i1][i2] = dfs(w1, w2, i1 - 1, i2 - 1, dp);
        } else {
            int insert = 1 + dfs(w1, w2, i1, i2 - 1, dp);
            int delete = 1 + dfs(w1, w2, i1 - 1, i2, dp);
            int replace = 1 + dfs(w1, w2, i1 - 1, i2 - 1, dp);

            dp[i1][i2] = Math.min(Math.min(insert, delete), replace);
        }
        return dp[i1][i2];
    }
}
