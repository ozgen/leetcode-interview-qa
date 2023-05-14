package backtracking.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II {
    /**
     * https://leetcode.com/problems/subsets-ii/
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, arr, ans);
        return ans;
    }

    private void subset(int[] nums, int idx, List<Integer> arr, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(arr));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            arr.add(nums[i]);
            subset(nums, i + 1, arr, ans);
            arr.remove(arr.size() - 1);
        }
    }
}
