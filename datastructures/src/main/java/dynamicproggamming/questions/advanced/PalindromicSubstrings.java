package dynamicproggamming.questions.advanced;

public class PalindromicSubstrings {

    /**
     * https://leetcode.com/problems/palindromic-substrings/
     */
    int res = 0;

    public int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) return len;

        for (int i = 0; i < len; i++) {
            //odd
            helper(s, i, i);
            //even
            helper(s, i, i + 1);
        }
        return res;
    }

    private void helper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res += 1;
            l--;
            r++;
        }
    }
}
