import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * https://leetcode.com/problems/contains-duplicate/
     */

    public static boolean containsDuplicate(int[] nums) {
        final Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
            int [] nums = new int[]{1,2,3,4,1};
        boolean duplicate = containsDuplicate(nums);
        System.out.println(duplicate);
    }
}
