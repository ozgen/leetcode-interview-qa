package binarysearch.questions;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 */
public class GuessHigherOrLower {


    public int guessNumber(int n){
        int low = 1;
        int high = n;

        while(true) {
            int mid = low + (high - low)/2;
            int myGuess = guess(mid);
            if(myGuess == 1)
                low = mid + 1;
            else if(myGuess == -1)
                high = mid - 1;
            else
                return mid;
        }
    }

    private int guess(int n) {
        if (n > 10) {
            return 1;
        } else if (n < 10) {
            return -1;
        } else {
            return 0;
        }
    }
}
