package dynamicproggamming.questions;

public class LongestCommonSubsequence {
    /**
     * https://leetcode.com/problems/longest-common-subsequence/
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int r = text1.length() - 1; r >= 0; r--) {
            for (int c = text2.length() - 1; c >= 0; c--) {
                if(text1.charAt(r) == text2.charAt(c)){
                    dp[r][c] = 1 + dp[r+1][c+1];
                }else {
                    dp[r][c] = Math.max(dp[r+1][c], dp[r][c+1]);
                }
            }
        }
        return dp[0][0];
    }
}
