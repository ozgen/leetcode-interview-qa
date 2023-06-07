public class LongestPalindromicSubstring {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/
     */

    public String longestPalindrome(String s) {
        String res = "";
        int len = 0;
        int r = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {

            // check odd
            r = i;
            l = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1 > len)) {
                    res = s.substring(l, r + 1);
                    len = r - l + 1;
                }
                l--;
                r++;
            }

            // check even
            r = i + 1;
            l = i;
            while( l >=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                if((r -l +1 > len)){
                    res = s.substring(l, r+1);
                    len = r -l +1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
