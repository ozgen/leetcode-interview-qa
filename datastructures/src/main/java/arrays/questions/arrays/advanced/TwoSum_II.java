package arrays.questions.arrays.advanced;

public class TwoSum_II {
    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                break;
            }
        }
        return new int[]{l + 1, r + 1};
    }
}
