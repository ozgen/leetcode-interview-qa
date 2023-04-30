public class ValidPalindrome {
    /**
     * https://leetcode.com/problems/valid-palindrome/description/
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char start = s.charAt(i);
        char end = s.charAt(j);


        while (i < j) {

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {

        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(validPalindrome.validPalindrome(s));
    }
}
