public class TriePrefixTree {
    /**
     * https://leetcode.com/problems/implement-trie-prefix-tree/description/
     */
    class Trie {
        private Node root;

        public Trie() {
            root = new Node('\0'); // dummy node for root
        }

        public void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node(c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.isLast = true;
        }

        public boolean search(String word) {
            Node n = getLast(word);
            return n != null && n.isLast;
        }

        public boolean startsWith(String prefix) {
            Node n = getLast(prefix);
            return n != null;
        }

        //helper for get last node
        private Node getLast(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    return null;
                }
                curr = curr.children[c - 'a'];
            }
            return curr;
        }

        class Node {
            private char val;
            private Node[] children;
            private boolean isLast;

            public Node(char val) {
                this.val = val;
                children = new Node[26];
                isLast = false;
            }
        }
    }
}
