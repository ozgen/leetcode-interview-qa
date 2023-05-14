package graphs.questions.advanced;

import java.util.PriorityQueue;
import java.util.Queue;

public class SwimInRisingWater {
    /**
     * https://leetcode.com/problems/swim-in-rising-water/
     */
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // Solution: Greedy Approach with Min Heap
    // Time Complexity: O((n^2)*log(n))
    public int swimInWater(int[][] grid) {
        int len = grid.length;
        if (len == 1) return 0;

        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{grid[0][0], 0, 0});
        boolean[][] seen = new boolean[len][len];
        seen[0][0] = true;

        int res = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            res = Math.max(res, cur[0]);
            if (cur[1] == len - 1 && cur[2] == len - 1) break;

            for (int[] d : dirs) {
                int r = cur[1] + d[0];
                int c = cur[2] + d[1];

                if (r < 0 || r >= len || c < 0 || c >= len || seen[r][c]) continue;

                q.add(new int[]{grid[r][c], r, c});
                seen[r][c] = true;
            }
        }
        return res;
    }
}
