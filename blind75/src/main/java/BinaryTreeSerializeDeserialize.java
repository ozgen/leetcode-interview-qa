import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeSerializeDeserialize {
    /**
     * https://leetcode.com/problems/serialize-and-deserialize-binary-tree
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

    // define a gloabal index
    private int i = 0;

    public String serialize(TreeNode root) {
        List<String> arr = new ArrayList<>();
        serializeDfs(root, arr);
        return String.join(",", arr);
    }

    private void serializeDfs(TreeNode root, List<String> arr) {
        if (root == null) {
            arr.add("N");
            return;
        }
        arr.add(String.valueOf(root.val));
        serializeDfs(root.left, arr);
        serializeDfs(root.right, arr);
    }

    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        return deserializeDfs(tokens);
    }

    private TreeNode deserializeDfs(String[] tokens) {
        String token = tokens[i];
        if (token.equals("N")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(token));
        i++;
        root.left = deserializeDfs(tokens);
        root.right = deserializeDfs(tokens);
        return root;
    }


}
