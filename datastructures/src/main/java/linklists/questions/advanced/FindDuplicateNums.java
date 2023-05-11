package linklists.questions.advanced;

public class FindDuplicateNums {
    /**
     * https://leetcode.com/problems/find-the-duplicate-number/
     */

    public int findDuplicate(int[] nums) {
        int f = 0;
        int s = 0;
        while (true) {
            s = nums[s];
            f = nums[nums[f]];
            if (f == s) break;
        }

        int s2 = 0;
        while (s2 != s) {
            s2 = nums[s2];
            s = nums[s];
        }
        return s;
    }
}
