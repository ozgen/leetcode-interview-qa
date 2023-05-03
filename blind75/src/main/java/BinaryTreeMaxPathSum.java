import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeMaxPathSum {
    /**
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
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

    public int maxPathSum(TreeNode root) {
        int[] res = {Integer.MIN_VALUE};
        findMaxPathSum(root, res);
        return res[0];
    }

    private int findMaxPathSum(TreeNode root, int[]res){
        if(root==null) return 0;
        int l = Math.max(0, findMaxPathSum(root.left, res));
        int r = Math.max(0, findMaxPathSum(root.right, res));

        res[0] = Math.max(res[0], root.val +l +r);
        return root.val + Math.max(r,l);
    }



}
