package dynamicproggamming.questions.advanced;

import java.util.Arrays;

public class CoinChange_II {
    /**
     * https://leetcode.com/problems/coin-change-ii/
     */

    // Dynammic Programming - Tabulation
    // Time Complexity (n * amount) | Space Complexity (amount) where n is the length of coins
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);

        dp[0] = 1; // if amount is 0, there is only 1 way of making change (no money)

        for (int c : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - c >= 0) {
                    dp[i] = dp[i] + dp[i - c];
                }
            }
        }
        return dp[amount];
    }


    public int change2(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        Arrays.fill(dp, -1);

        return dfs(coins, 0, amount, dp);

    }

    private int dfs(int[] coins, int index, int amount, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (index == coins.length) {
            return 0;
        }
        if (dp[amount][index] != -1) {
            return dp[amount][index];
        }

        return dp[amount][index] = dfs(coins, index, amount - coins[index], dp) + dfs(coins, index + 1, amount, dp);

    }

}
