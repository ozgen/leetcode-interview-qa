package backtracking.questions;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    /**
     * https://leetcode.com/problems/combinations/
     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(n, 1, new ArrayList<>(), ans, k);
        return ans;
    }

    private void combine(int n, int idx, List<Integer> arr, List<List<Integer>> ans, int k) {
        if (arr.size() == k) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        if (idx > n) return;

        for (int i = idx; i < n + 1; i++) {
            arr.add(i);
            combine(n, i + 1, arr, ans, k);
            arr.remove(arr.size() - 1);
        }
    }
}
