package graphs.questions.advanced;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostConnectAllPoints {
    /**
     * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
     */
    public int minCostConnectPoints(int[][] points) {

        int len = points.length;
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visit = new boolean[len];
        q.add(new int[]{0, 0});
        int minCost = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cost = cur[0];
            int point = cur[1];
            if (visit[point]) {
                continue;
            }
            visit[point] = true;
            minCost += cost;

            for (int i = 0; i < len; i++) {
                if (!visit[i]) {
                    q.add(new int[]{distance(points[point], points[i]), i});
                }
            }
        }
        return minCost;
    }

    private int distance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
