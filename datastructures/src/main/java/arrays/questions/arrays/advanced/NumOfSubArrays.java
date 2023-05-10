package arrays.questions.arrays.advanced;

public class NumOfSubArrays {

    /**
     * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
     */

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int l = 0;
        int total = 0;

        for(int r = 0; r < arr.length; r++){

            if(r - l + 1 > k){
                if(total / k >= threshold){
                    res +=1;
                }
                total -= arr[l];
                l++;
            }
            total += arr[r];
            if(r == arr.length -1){
                if(total / k >= threshold){
                    res +=1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{2,2,2,2,5,5,5,8};
        NumOfSubArrays numOfSubArrays = new NumOfSubArrays();
        int res = numOfSubArrays.numOfSubarrays(arr, 3, 4);
        System.out.println(res);
    }
}
