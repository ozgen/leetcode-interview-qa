package trees.questions.advanced;

import trees.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTIterator {
    /**
     * https://leetcode.com/problems/binary-search-tree-iterator/
     */

    Queue<Integer> q;

    public BSTIterator(TreeNode root) {
        q = new ArrayDeque();
        fillQueue(root);
    }

    private void fillQueue(TreeNode node){
        if(node.left != null){
            fillQueue(node.left);
        }
        q.add(node.val);
        if(node.right != null){
            fillQueue(node.right);
        }
    }

    public int next() {
        while(!q.isEmpty()){
            return q.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
