package arrays.questions.arrays.advanced;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_II {
    /**
     * https://leetcode.com/problems/contains-duplicate-ii/
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (r - l > k) {
                set.remove(nums[l]);
                l++;
            }
            if (set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r]);
        }
        return false;
    }
}
