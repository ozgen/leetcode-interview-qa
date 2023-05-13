package trees.questions.advanced;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePreorderTraversal {
    /**
     * https://leetcode.com/problems/binary-tree-preorder-traversal/
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Queue<Integer> q = new ArrayDeque();
        fillQueue(root, q);
        return new ArrayList<Integer>(q);
    }

    private void fillQueue(TreeNode n, Queue<Integer>q){
        if(n == null) return;
        q.add(n.val);
        if(n.left != null) fillQueue(n.left, q);
        if(n.right != null) fillQueue(n.right, q);
    }
}
