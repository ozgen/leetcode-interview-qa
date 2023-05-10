package bitmanipulation.questions;

public class NumberOf1Bits {

    /**
     * https://leetcode.com/problems/number-of-1-bits
     */
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            n = n & (n - 1);
            c += 1;
        }
        return c;
    }
    /**
     * 1011
     * 1010 &
     * 1010
     * 1001 &
     * 1000
     * 0111 &
     * 0000
     */
}
