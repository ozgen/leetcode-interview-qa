import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    /**
     * https://leetcode.com/problems/pacific-atlantic-water-flow/
     */

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, heights[0][c], pacific);
            dfs(heights, ROWS - 1, c, heights[ROWS - 1][c], atlantic);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, heights[r][0], pacific);
            dfs(heights, r, COLS - 1, heights[r][COLS - 1], atlantic);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (atlantic[r][c] && pacific[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prev, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) return;
        if (heights[r][c] < prev || visited[r][c]) return;
        visited[r][c] = true;
        dfs(heights, r + 1, c, heights[r][c], visited);
        dfs(heights, r - 1, c, heights[r][c], visited);
        dfs(heights, r, c + 1, heights[r][c], visited);
        dfs(heights, r, c - 1, heights[r][c], visited);
    }


}
