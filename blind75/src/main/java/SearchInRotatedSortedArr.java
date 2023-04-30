public class SearchInRotatedSortedArr {

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     */

    public int search(int[] nums, int target) {
        int min = findMin(nums);
        int lr = binarySearch(0, min-1, target, nums);
        int rr = binarySearch(min, nums.length -1, target, nums);

        if(lr != -1){
            return lr;
        }else if ( rr != -1){
            return rr;
        }else return -1;
    }

    private int findMin(int[] nums){

        int l = 0;
        int r = nums.length -1;

        while(l<=r){
            if(nums[l]<=nums[r]){
                return l;
            }
            int m = (l+r) /2;
            if(nums[l] <=nums[m]){
                l = m+1;
            }else{
                r = m;
            }
        }
        return 0;
    }

    private int binarySearch( int s, int e, int target, int[] nums){
        while (s<= e){
            int m = (s+e)/2;
            if(target == nums[m]){
                return m;
            }
            else if(nums[m]>target){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return -1;
    }
}
