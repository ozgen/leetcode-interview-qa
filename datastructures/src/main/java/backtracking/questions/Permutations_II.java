package backtracking.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_II {
    /**
     * https://leetcode.com/problems/permutations-ii
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        return permute(0, nums);
    }

    private List<List<Integer>> permute(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> perms = permute(i + 1, nums);

        for (List<Integer> p : perms) {
            for (int j = 0; j < p.size() + 1; j++) {
                List<Integer> pCopy = new ArrayList<>();
                pCopy.addAll(p);
                pCopy.add(j, nums[i]);
                result.add(pCopy);
            }
        }
        return  new ArrayList<>(result);
    }
}
