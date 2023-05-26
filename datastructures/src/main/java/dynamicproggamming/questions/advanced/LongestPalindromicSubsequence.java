package dynamicproggamming.questions.advanced;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    /**
     * https://leetcode.com/problems/longest-palindromic-subsequence/
     */

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(s, dp, 0, n - 1, n);
    }

    public int helper(String str, Integer[][] dp, int l, int r, int n) {
        if (l >= n || l < 0 || r >= n || r < 0)
            return 0;
        if (dp[l][r] != null)
            return dp[l][r];
        if (str.charAt(l) == str.charAt(r))
            return dp[l][r] = 1 + helper(str, dp, l + 1, r - 1, n);
        int a = helper(str, dp, l + 1, r, n);
        int b = helper(str, dp, l, r - 1, n);
        return dp[l][r] = Math.max(a, b);
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence subsequence = new LongestPalindromicSubsequence();
        String s = "aabaa";
        int i = subsequence.longestPalindromeSubseq(s);
        System.out.println(i);
    }
}
