public class SubTreeOfAnotherTree {
    /**
     * https://leetcode.com/problems/same-tree/
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (isSame(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode r, TreeNode s) {
        if (r == null && s == null) return true;
        if (r == null || s == null) return false;

        if (r.val == s.val) {
            return isSame(r.right, s.right) && isSame(r.left, s.left);
        }
        return false;
    }

}
