import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {
    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     */
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            if (list.contains(s.charAt(r))) {

                int i = list.indexOf(s.charAt(r));
                list.remove(i);
                if (i > 0) {
                    list.subList(0, i).clear();
                }
            }
            list.add(s.charAt(r));
            res = Math.max(res, list.size());
        }
        return res;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring exe = new LengthOfLongestSubstring();
        String s = "pwwkew";
        System.out.println(exe.lengthOfLongestSubstring(s));
    }
}
