import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KthSmallestElementInBST {
    /**
     * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        order(root, list);
        return list.get(k - 1);
    }

    private void order(TreeNode r, List<Integer> list) {
        if (r == null) return;
        order(r.left, list);
        list.add(r.val);
        order(r.right, list);
    }

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        order2(root, list, k);
        return list.get(k - 1);
    }

    private void order2(TreeNode r, List<Integer> list, int k) {
        if (r == null || list.size() == k) return;
        order2(r.left, list, k);
        if (list.size() < k)
            list.add(r.val);
        order2(r.right, list, k);
    }
}
