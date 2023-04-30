
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestConsecutiveNumber {

    /**
     * https://leetcode.com/problems/longest-consecutive-sequence/
     * @param nums
     * @return
     */
    public int longestConsecutive(List<Integer> nums) {
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int i : nums) set.add(i);

        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int c = 1;
                while (set.contains(i+1)){
                    i++;
                    c++;
                    res = Math.max(c, res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveNumber longestConsecutiveNumber = new LongestConsecutiveNumber();
        List<Integer> list = List.of(5, 4, 3, 2, 100, 10);
        System.out.println(longestConsecutiveNumber.longestConsecutive(list));
    }
}
