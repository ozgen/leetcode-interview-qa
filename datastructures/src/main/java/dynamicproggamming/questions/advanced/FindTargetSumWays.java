package dynamicproggamming.questions.advanced;

public class FindTargetSumWays {

    /**
     * https://leetcode.com/problems/target-sum/
     * [1, 1, 1 ] target = 2
     * (0,0)
     * (1, 1)      (1, -1)
     * (2, 2) (2, 0)  (2,0) (2, -2)
     * (3, 3) (3 ,1)
     */

    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, target, nums.length, 0);
    }

    private int backtrack(int[] nums, int target, int idx, int tmp) {
        if (idx == 0) {
            return target == tmp ? 1 : 0;
        } else {
            return backtrack(nums, target - nums[idx - 1], idx - 1, tmp) +
                    backtrack(nums, target + nums[idx - 1], idx - 1, tmp);
        }
    }


}
