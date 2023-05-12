package trees.questions.advanced;

import java.util.HashMap;

class WordFilter {
    /**
     * https://leetcode.com/problems/prefix-and-suffix-search/
     */
    public class Trie {
        Trie[] children; //for children
        HashMap<String, Integer> map; // for index store
        public Trie() {
            children = new Trie[26];
            map = new HashMap<>();
        }
    }
    private Trie root;
    public WordFilter(String[] words) {
        int n = words.length;
        this.root = new Trie();
        Trie cur = root;
        for (int i = 0; i < n; i++) {
            int len = words[i].length();
            for (char c: words[i].toCharArray()) {
                int cIndex = c - 'a';
                if (cur.children[cIndex] == null) {
                    cur.children[cIndex] = new Trie();
                }
                cur = cur.children[cIndex];
                for (int j = 0; j < len; j++) {
                    cur.map.put(words[i].substring(j), i);
                }
            }
            cur = root;
        }
    }

    public int f(String prefix, String suffix) {
        Trie cur = this.root;
        for (char c: prefix.toCharArray()) {
            int cIndex = c - 'a';
            if (cur.children[cIndex] == null) return -1;
            cur = cur.children[cIndex];
        }

        return cur.map.getOrDefault(suffix, -1);
    }
}