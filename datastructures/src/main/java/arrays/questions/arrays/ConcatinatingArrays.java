package arrays.questions.arrays;

import java.util.Arrays;

public class ConcatinatingArrays {

    /**
     * https://leetcode.com/problems/concatenation-of-array/
     */

    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[(2 * nums.length)];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ConcatinatingArrays ca = new ConcatinatingArrays();
        int []nums = new int[]{1,2,3};
        int[] res = ca.getConcatenation(nums);
        Arrays.stream(res).forEach(System.out::println);
    }
}
