package dynamicproggamming.questions.advanced;

public class LongestCommonSubsequence {
    /**
     * https://leetcode.com/problems/longest-common-subsequence/
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int r = text1.length() - 1; r >= 0; r--) {
            for (int c = text2.length() - 1; c >= 0; c--) {
                if (text1.charAt(r) == text2.charAt(c)) {
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                } else {
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length() + 1][text2.length() + 1];
        return dfs(text1, text2, 0, 0, dp);
    }

    private int dfs(String txt1, String txt2, int i1, int i2, Integer[][] dp) {
        if (i1 == txt1.length() || i2 == txt2.length()) {
            return 0;
        }
        if (dp[i1][i2] != null) return dp[i1][i2];

        if (txt1.charAt(i1) == txt2.charAt(i2)) {
            dp[i1][i2] = 1 + dfs(txt1, txt2, i1 + 1, i2 + 1, dp);
        } else {
            dp[i1][i2] = Math.max(
                    dfs(txt1, txt2, i1 + 1, i2, dp),
                    dfs(txt1, txt2, i1, i2 + 1, dp)
            );
        }
        return dp[i1][i2];
    }

}
