public class WordSearch {
    /**
     * https://leetcode.com/problems/word-search/
     */
    int COLS, ROWS;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        boolean res = false;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(dfs(r,c,0,board, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int i, char[][] board, String word){
        if(i == word.length()){
            return true;
        }
        if(
                r < 0 ||
                        c < 0 ||
                        r >= ROWS ||
                        c >= COLS ||
                        word.charAt(i)!= board[r][c]
        ) return false;
        boolean res = false;
        if(word.charAt(i) == board[r][c]){
            board[r][c] += 100;
            res = dfs(r+1, c, i+1, board, word) ||
                    dfs(r-1, c, i+1, board, word) ||
                    dfs(r, c+1, i+1, board, word) ||
                    dfs(r, c-1, i+1, board, word);
            board[r][c] -= 100;
        }
        return res;
    }
}
