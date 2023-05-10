package dynamicproggamming.questions;

public class UniquePaths {
    /**
     * https://leetcode.com/problems/unique-paths/
     */

    public int uniquePaths(int m, int n) {
        int [] prevRow = new int[n];
        for(int i = m-1; i >=0; i--){
            int [] curRow = new int[n];
            curRow[n-1]=1;
            for (int j = n-2; j>=0; j--){
                curRow[j] = curRow[j+1] + prevRow[j];
            }
            prevRow = curRow;
        }
        return prevRow[0];
    }
}
