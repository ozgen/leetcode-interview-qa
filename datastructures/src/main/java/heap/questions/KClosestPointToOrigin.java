package heap.questions;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {

    /**
     * https://leetcode.com/problems/k-closest-points-to-origin/
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for (int[] p : points) q.add(p);

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] p = q.poll();
            ans[i][0] = p[0];
            ans[i][1] = p[1];
        }
        return ans;
    }
}
