public class SumOfTwoIntegers {

    /**
     * https://leetcode.com/problems/sum-of-two-integers/
     */

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}
