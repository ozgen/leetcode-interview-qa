public class LongestRepeatingCharReplacement {
    /**
     * https://leetcode.com/problems/longest-repeating-character-replacement/
     */
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int ans = 0;
        int l = 0;
        int maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            arr[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, arr[s.charAt(r) - 'A']);
            if (r - l + 1 - maxf > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        LongestRepeatingCharReplacement replacement = new LongestRepeatingCharReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(replacement.characterReplacement(s, k));
    }


}
