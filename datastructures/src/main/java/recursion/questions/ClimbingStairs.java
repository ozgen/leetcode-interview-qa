package recursion.questions;

import java.util.Arrays;

public class ClimbingStairs {
    /**
     * https://leetcode.com/problems/climbing-stairs/description/
     */

    // optimal
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;

        for (int i = 2; i <= n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    // buttom up
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
  // top down with memo[]
    public int climbStairs3(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }

    private int climbStairs(int n, int[] memo) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) {
            memo[n] = 1;
            return memo[n];
        }
        if (memo[n] != -1) return memo[n];

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }
}
