import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBinaryTree {
    /**
     * https://leetcode.com/problems/validate-binary-search-tree/
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

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer l, Integer r) {
        if (root == null) return true;
        if ((l != null && l >= root.val) || (r != null && r <= root.val)) return false;
        return isValid(root.left, l, root.val) && isValid(root.right, root.val, r);
    }

}
