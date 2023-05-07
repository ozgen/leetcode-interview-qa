package trees.questions;


import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSide {
    /**
     * https://leetcode.com/problems/binary-tree-right-side-view/
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {
        List <Integer> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if(root==null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i =0; i<len; i++){
                TreeNode n = q.poll();
                if(i ==0)res.add(n.val);

                if (n.right != null) {
                    q.add(n.right);
                }
                if (n.left != null) {
                    q.add(n.left);
                }
            }
        }
        return res;
    }
}
