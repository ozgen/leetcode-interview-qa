package binarysearch.questions;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int low = 1;
        int high = n;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    private boolean isBadVersion(int n) {
        if (n >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(100));
    }
}
