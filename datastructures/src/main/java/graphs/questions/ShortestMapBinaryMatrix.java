package graphs.questions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestMapBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1) return -1;
        int[][] visit = new int[n][n];
        Queue<int[]> q = new LinkedList();
        q.add(new int[2]); // Add {0, 0}
        visit[0][0] = 1;

        int length = 1;
        while (!q.isEmpty()) {

            int queueLength = q.size();
            for (int i = 0; i < queueLength; i++) {

                int[] pair = q.poll();
                int r = pair[0], c = pair[1];
                if (r == n - 1 && c == n - 1) {
                    return length;
                }
                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}, {r + 1, c + 1}, {r + 1, c - 1}, {r - 1, c + 1}, {r - 1, c - 1}};
                for (int j = 0; j < 8; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (newR < 0 || newC < 0 || newR == n || newC == n
                            || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }
                    q.add(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            }
            length++;
        }
        if (grid[n - 1][n - 1] == 1 || visit[n - 1][n - 1] == 0) return -1;
        return length;

    }


    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0}};
        ShortestMapBinaryMatrix matrix = new ShortestMapBinaryMatrix();
        int res = matrix.shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }
}
