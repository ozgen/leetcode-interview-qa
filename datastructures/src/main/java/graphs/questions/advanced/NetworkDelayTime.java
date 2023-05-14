package graphs.questions.advanced;

import java.util.Arrays;

public class NetworkDelayTime {
    /**
     * https://leetcode.com/problems/network-delay-time/
     */

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] paths = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[k - 1] = 0;
        for (int i = 0; i < n; i++) {

            int[] tmp = new int[n];
            tmp = Arrays.copyOf(paths, paths.length);
            for (int t = 0; t < times.length; t++) {
                int src = times[t][0];
                int des = times[t][1];
                int time = times[t][2];

                if (tmp[src - 1] != Integer.MAX_VALUE && tmp[src - 1] + time < tmp[des - 1]) {
                    tmp[des - 1] = tmp[src - 1] + time;
                }
            }
            paths = tmp;
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (paths[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, paths[i]);
        }
        return res;
    }
}
