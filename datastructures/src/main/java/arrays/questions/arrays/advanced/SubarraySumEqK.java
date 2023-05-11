package arrays.questions.arrays.advanced;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqK {
    /**
     * https://leetcode.com/problems/subarray-sum-equals-k/
     * <p>
     * <p>
     * 1 -1 1 1 1     k = 3
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            if (map.containsKey(diff)) {
                res += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
