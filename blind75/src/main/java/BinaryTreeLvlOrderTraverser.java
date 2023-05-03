import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLvlOrderTraverser {
    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();
            ArrayList<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode n = q.poll();
                lvl.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            res.add(lvl);
        }
        return res;
    }

}
