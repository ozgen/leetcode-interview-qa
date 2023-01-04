package recursion.factorial;

public class MyFactorial {

    // Recursive implementation of n! (n-factorial) calculation

        public static int factorial(int n) {

            // Base case: n = 0 or 1
            if (n <= 1) {
                return 1;
            }

            // Recursive case: n! = n * (n - 1)!
            return n * factorial(n-1);
        }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
