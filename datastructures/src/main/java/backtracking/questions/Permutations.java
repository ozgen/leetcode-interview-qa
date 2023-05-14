package backtracking.questions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * https://leetcode.com/problems/permutations/
     */

    public List<List<Integer>> permute(int[] nums) {
        return permute(0, nums);
    }

    private List<List<Integer>> permute(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> perms = permute(i + 1, nums);

        for (List<Integer> p : perms) {
            for (int j = 0; j < p.size() + 1; j++) {
                List<Integer> pCopy = new ArrayList<>();
                pCopy.addAll(p);
                pCopy.add(j, nums[i]);
                result.add(pCopy);
            }
        }
        return result;
    }
}
