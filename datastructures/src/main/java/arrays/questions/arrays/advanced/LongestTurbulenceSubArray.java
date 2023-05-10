package arrays.questions.arrays.advanced;

public class LongestTurbulenceSubArray {
    /**
     * https://leetcode.com/problems/longest-turbulent-subarray/
     */
    public int maxTurbulenceSize(int[] arr) {
        int l = 0;
        int r = 1;
        String prev = "";
        int res = 1;
        while (r < arr.length) {
            if ((arr[r - 1] > arr[r]) && prev != ">") {
                res = Math.max(res, r - l + 1);
                r += 1;
                prev = ">";
            } else if ((arr[r - 1] < arr[r]) && prev != "<") {
                res = Math.max(res, r - l + 1);
                r += 1;
                prev = "<";
            } else {
                if (arr[r - 1] == arr[r]) {
                    r = r + 1;
                }
                l = r - 1;
                prev = "";
            }
        }
        return res;
    }
}
