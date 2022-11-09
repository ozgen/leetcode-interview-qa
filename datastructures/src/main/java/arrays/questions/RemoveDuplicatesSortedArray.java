package arrays.questions;

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int retVal = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[retVal++] = nums[i];
            }
        }
        nums[retVal++] = nums[nums.length - 1];
        return retVal;
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
        int [] nums = new int[] {1,1,1,2,2,2,3,3,3};
        int uniques = removeDuplicatesSortedArray.removeDuplicates(nums);
        System.out.println(uniques);

    }

}
