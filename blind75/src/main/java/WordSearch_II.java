import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordSearch_II {
    /**
     * https://leetcode.com/problems/word-search-ii/
     */
    int ROWS = 0;
    int COLS = 0;

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.addWord(word);
        }

        ROWS = board.length;
        COLS = board[0].length;
        HashSet<String> res = new HashSet<>();
        HashSet<String> visit = new HashSet<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r, c, root, "", res, visit, board, root);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(int r, int c, Trie node, String word, HashSet<String> res, HashSet<String> visit, char[][] board, Trie root) {
        if (
                r < 0 ||
                        c < 0 ||
                        r == ROWS ||
                        c == COLS ||
                        !node.children.containsKey(board[r][c]) ||
                        node.children.get(board[r][c]).refs < 1 ||
                        visit.contains(r + "-" + c)
        ) {
            return;
        }
        visit.add(r + "-" + c);
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if (node.isWord) {
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }
        dfs(r + 1, c, node, word, res, visit, board, root);
        dfs(r - 1, c, node, word, res, visit, board, root);
        dfs(r, c + 1, node, word, res, visit, board, root);
        dfs(r, c - 1, node, word, res, visit, board, root);
        visit.remove(r + "-" + c);


    }

    class Trie {

        HashMap<Character, Trie> children;
        boolean isWord;
        int refs = 0;

        public Trie() {
            children = new HashMap();
        }

        public void addWord(String word) {
            Trie curr = this;
            curr.refs += 1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Trie());
                }
                curr = curr.children.get(c);
                curr.refs += 1;
            }
            curr.isWord = true;
        }

        public void removeWord(String word) {
            Trie curr = this;
            curr.refs -= 1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                    curr.refs -= 1;
                }
            }
        }
    }
}
