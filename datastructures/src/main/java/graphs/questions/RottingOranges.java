package graphs.questions;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /**
     * https://leetcode.com/problems/rotting-oranges/
     * @param grid
     * @return
     */

    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> q = new LinkedList();
        int fresh = 0;

        for (int i = 0; i < ROWS; i += 1) {
            for (int j = 0; j < COLS; j += 1) {
                if (grid[i][j] == 2) q.offer(new int[] { i, j }); else if (
                        grid[i][j] == 1
                ) fresh += 1;
            }
        }
        int count = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while(!q.isEmpty() && fresh != 0){
            count += 1;
            int sz = q.size();
            for (int i = 0; i < sz; i += 1) {
                int[] rotten = q.poll();
                int r = rotten[0], c = rotten[1];
                for (int[] dir : dirs) {
                    int x = r + dir[0], y = c + dir[1];
                    if (0 <= x && x < ROWS && 0 <= y && y < COLS && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new int[] { x, y });
                        fresh -= 1;
                    }
                }
            }

        }
        return fresh == 0 ? count : -1;

    }
}
