import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    /**
     * https://leetcode.com/problems/two-sum/
     */

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(nums[i])) {
                return new int[]{prevMap.get(num), i};
            }

            prevMap.put(diff, i);
        }

        return new int[]{};

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 1};
        int sum = 6;
        int[] ints = twoSum(nums, sum);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
