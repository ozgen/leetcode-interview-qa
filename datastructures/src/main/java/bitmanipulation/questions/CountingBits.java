package bitmanipulation.questions;

public class CountingBits {
    /**
     * https://leetcode.com/problems/counting-bits/
     */

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = count(i);
        }
        return ans;
    }

    private int count(int n) {
        int c = 0;
        while (n != 0) {
            n = n & (n - 1);
            c += 1;
        }
        return c;
    }
}
