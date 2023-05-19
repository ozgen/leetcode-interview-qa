package dynamicproggamming.questions.advanced;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {

    /**
     * https://leetcode.com/problems/partition-equal-subset-sum/
     */

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Set<Integer> set = new HashSet<>();
        set.add(0); // initialize with 0
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> nSet = new HashSet<>();
            for (int n : set) {
                nSet.add(n);
                nSet.add(n + nums[i]);
            }
            set = nSet;
        }
        return set.contains(target);
    }

    /**
     * todo need to review this approach...
     * @param nums
     * @return
     */

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        int n = nums.length;

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if (i == 0 || j == 0) {
                    if (i == 0) dp[i][j] = false; else if (j == 0) dp[i][j] =
                            true;
                } else if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
