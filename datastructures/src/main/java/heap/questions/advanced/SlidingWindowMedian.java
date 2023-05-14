package heap.questions.advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {
    /**
     * todo review this answer...
     * https://leetcode.com/problems/sliding-window-median/description/
     */

    class SegmentTree {
        private final int[] tree;

        public SegmentTree(int n) {
            tree = new int[4 * n];
        }

        public int getKthIndex(int idx, int start, int end, int k) {
            if (start == end) {
                return start;
            }
            else {
                int mid = (start + end) / 2;
                if (k <= tree[2 * idx + 1]) {
                    return getKthIndex(2 * idx + 1, start, mid, k);
                }
                else {
                    return getKthIndex(2 * idx + 2, mid + 1, end, k - tree[2 * idx + 1]);
                }
            }
        }

        public void update(int idx, int start, int end, int id, int val) {
            if (start == end) {
                tree[idx] = val;
            }
            else {
                int mid = (start + end) / 2;
                if (id <= mid) {
                    update(2 * idx + 1, start, mid, id, val);
                }
                else {
                    update(2 * idx + 2, mid + 1, end, id, val);
                }
                tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
            }
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            position[pairs[i][1]] = i;
        }
        SegmentTree tree = new SegmentTree(n);
        for (int i = 0; i < k; i++) {
            tree.update(0, 0, n - 1, position[i], 1);
        }
        double[] medians = new double[n - k + 1];
        medians[0] = pairs[tree.getKthIndex(0, 0, n - 1, k / 2 + 1)][0];
        if (k % 2 == 0) {
            medians[0] += pairs[tree.getKthIndex(0, 0, n - 1, k / 2)][0];
        }
        for (int i = k; i < n; i++) {
            tree.update(0, 0, n - 1, position[i - k], 0);
            tree.update(0, 0, n - 1, position[i], 1);
            medians[i - k + 1] = pairs[tree.getKthIndex(0, 0, n - 1, k / 2 + 1)][0];
            if (k % 2 == 0) {
                medians[i - k + 1] += pairs[tree.getKthIndex(0, 0, n - 1, k / 2)][0];
            }
        }
        if (k % 2 == 0) {
            for (int i = 0; i < medians.length; i++) {
                medians[i] /= 2;
            }
        }
        return medians;
    }


}
