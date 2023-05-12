package trees.questions.advanced;

public class DesignAndSearchWords {
    /**
     * https://leetcode.com/problems/design-add-and-search-words-data-structure/
     */

    class WordDictionary {

        private Node root;

        public WordDictionary() {
            root = new Node('\0'); //dummy node
        }

        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node(c);
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, Node curr, int index) {
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);

                if(c =='.'){
                    for(Node n : curr.children){
                        if(n!=null && search(word, n, i +1)){
                            return true;
                        }
                    }
                    return false;
                }

                if(curr.children[c-'a'] ==null){
                    return false;
                }
                curr = curr.children[c-'a'];
            }
            return curr.isEnd;
        }

        class Node {
            char val;
            Node[] children;
            boolean isEnd;

            public Node(char val) {
                this.val = val;
                children = new Node[26];
                isEnd = false;
            }
        }
    }
}
