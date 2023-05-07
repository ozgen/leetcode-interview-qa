package graphs.questions;

public class MaxAreaOfIsland {
    /**
     * https://leetcode.com/problems/max-area-of-island/
     */

    int ROWS, COLS;
    public int maxAreaOfIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int res = 0;
        for(int r=0; r< ROWS; r++){
            for(int c = 0; c<COLS; c++){
                if(grid[r][c] ==1){
                    res = Math.max(dfs(grid, r,c,new int[] { 0 }), res);
                }
            }
        }
        return res;
    }

    private int dfs(int[][]grid, int r, int c, int[] curr){
        if(
                r < 0 ||
                        c < 0 ||
                        r >= ROWS ||
                        c >= COLS ||
                        grid[r][c] ==0
        ){
            return curr[0];
        }
        grid[r][c] = 0;
        curr[0] ++;
        dfs(grid, r+1, c, curr);
        dfs(grid, r-1, c, curr);
        dfs(grid, r, c+1, curr);
        dfs(grid, r, c-1, curr);
        return curr[0];
    }
}
