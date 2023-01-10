package sorting.questions;

public class SortColor {

    /**
     * https://leetcode.com/problems/sort-colors/description/
     */

    public void sortColors(int[] nums) {
        int[] c = {0, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            c[nums[i]] += 1;
        }
        int n = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i]; j++) {
                nums[n] = i;
                n++;
            }
        }
    }
}
