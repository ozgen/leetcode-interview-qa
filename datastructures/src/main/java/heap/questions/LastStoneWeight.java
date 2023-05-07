package heap.questions;

import linklists.queue.Queue;

import java.util.PriorityQueue;

public class LastStoneWeight {

    /**
     * https://leetcode.com/problems/last-stone-weight/
     */

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int s : stones) q.add(s);

        while (q.size() > 1) {
            int s1 = q.poll();
            int s2 = q.poll();
            if (s1 != s2) q.add(s1 - s2);
        }
        return q.size() != 0 ? q.peek() : 0;
    }
}
