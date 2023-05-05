public class NumberOfIslands {

    /**
     * https://leetcode.com/problems/number-of-islands/description/
     */
    int ROWS, COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int cnt = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (
                r < 0 ||
                        c < 0 ||
                        r >= ROWS ||
                        c >= COLS ||
                        grid[r][c] == '0'
        ) {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
