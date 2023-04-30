import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TreeSum {
    /**
     * https://leetcode.com/problems/3sum/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> solution = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {

                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        solution.add(tmp);
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < target) left++;
                    else right--;
                }
            }
        }
        return solution;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if (nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                else if (sum > 0) right--;
                else if (sum < 0) left++;
            }
        }
        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        TreeSum treeSum = new TreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = treeSum.threeSum(nums);
        List<List<Integer>> lists2 = treeSum.threeSum2(nums);
        lists.forEach(System.out::println);
        lists2.forEach(System.out::println);
    }
}
