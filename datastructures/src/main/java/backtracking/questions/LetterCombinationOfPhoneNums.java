package backtracking.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNums {

    /**
     * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
     */
    private Map<Character, String> map = Map.of(
            '2',
            "abc",
            '3',
            "def",
            '4',
            "ghi",
            '5',
            "jkl",
            '6',
            "mno",
            '7',
            "pqrs",
            '8',
            "tuv",
            '9',
            "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        backtrack(digits, 0, ans, "");
        return ans;
    }

    private void backtrack(String digits, int idx, List<String> ans, String cur) {
        if (digits.length() == cur.length()) {
            ans.add(cur);
            return;
        } else if (idx >= digits.length()) {
            return;
        } else {
            String digit = map.get(digits.charAt(idx));
            for (char c : digit.toCharArray()) {
                backtrack(digits, idx + 1, ans, cur + c);
            }
        }
    }
}
