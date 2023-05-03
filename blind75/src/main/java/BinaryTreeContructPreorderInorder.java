import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeContructPreorderInorder {
    /**
     *https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length== 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int m = 0;
        for(int i = 0; i< inorder.length; i++){
            if(root.val== inorder[i]){
                m = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1,m+1), Arrays.copyOfRange(inorder, 0,m));
        root.right = buildTree(Arrays.copyOfRange(preorder,m+1,preorder.length), Arrays.copyOfRange(inorder, m+1, inorder.length));
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(root.val);
        int leftSubtreeSize = inIndex - inStart;
        root.left = buildTreeHelper(preorder, inorder, preStart + 1, preStart + leftSubtreeSize, inStart, inIndex - 1, map);
        root.right = buildTreeHelper(preorder, inorder, preStart + leftSubtreeSize + 1, preEnd, inIndex + 1, inEnd, map);
        return root;
    }

}
