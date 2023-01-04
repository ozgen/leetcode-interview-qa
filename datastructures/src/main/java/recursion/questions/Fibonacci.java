package recursion.questions;

// Recursive implementation to calculate the n-th Fibonacci number
public class Fibonacci {

    /**
     * https://leetcode.com/problems/fibonacci-number/description/
     */

    // Base case: n = 0 or 1
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Recursive case: fib(n) = fib(n - 1) + fib(n - 1)
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int fib(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        if(n<=1){
            return n;
        }
        for(int i =2; i<n+1; i++){
            n3 = n1+n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }
}