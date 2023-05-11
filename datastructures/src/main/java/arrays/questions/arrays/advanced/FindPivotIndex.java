package arrays.questions.arrays.advanced;

public class FindPivotIndex {
    /**
     *https://leetcode.com/problems/find-pivot-index/
     */

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int n : nums){
            total +=n;
        }
        int leftS = 0;

        for(int i = 0; i < nums.length; i++){
            int rightS = total - leftS - nums[i];
            if(rightS == leftS){
                return i;
            }
            leftS += nums[i];
        }
        return -1;
    }

    }
