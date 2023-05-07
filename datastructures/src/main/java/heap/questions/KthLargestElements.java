package heap.questions;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElements {
    /**
     * https://leetcode.com/problems/kth-largest-element-in-a-stream/
     */

    class KthLargest {

        Queue<Integer> q = new PriorityQueue<Integer>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int n : nums) add(n);
        }

        public int add(int val) {
            if (q.size() < k) q.offer(val);
            else if (val > q.peek()) {
                q.poll(); //remove the top element
                q.add(val); //add the new element
            }
            return q.peek();

        }
    }
}
