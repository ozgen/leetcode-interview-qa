package heap.questions.advanced;

import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {
    /**
     * https://leetcode.com/problems/ipo/description/
     */

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<int[]> smallHeap = new PriorityQueue<int[]>((a, b)-> a[0] - b[0]);
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a, b)-> b - a);
        for(int i = 0; i < profits.length; i ++){
            smallHeap.add(new int[]{capital[i], profits[i]});
        }

        for(int i = 0; i < k; i++){

            while(!smallHeap.isEmpty() && smallHeap.peek()[0] <= w){
                int[] tmp = smallHeap.poll();
                maxHeap.add(tmp[1]);
            }

            if(!maxHeap.isEmpty()){
                w += maxHeap.poll();
            }
        }
        return w;

    }
}
