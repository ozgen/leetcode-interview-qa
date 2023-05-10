package bitmanipulation.questions;

public class RevereBits {
    /**
     * https://leetcode.com/problems/reverse-bits/
     */

    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1); // to get single bit & 1 is used.
            n >>= 1;
        }
        return  ans;
    }
}
