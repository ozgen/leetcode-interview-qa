package dynamicproggamming.questions.advanced;

public class OnesAndZeros {
    /**
     * https://leetcode.com/problems/ones-and-zeroes/description/
     */

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int mC = (int) s.chars().filter(c -> c == '0').count();
            int nC = (int) s.chars().filter(c -> c == '1').count();

            for (int i = m; i >= mC; i--) {
                for (int j = n; j >= nC; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - mC][j - nC]);
                }
            }
        }
        return dp[m][n];
    }
}
