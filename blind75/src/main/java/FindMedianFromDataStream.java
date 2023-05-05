import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
    /**
     * https://leetcode.com/problems/find-median-from-data-stream/
     */
    class MedianFinder {

        Queue<Integer> smallH; // store small nums - maxHeap
        Queue<Integer> largeH; // store large nums - minHeap

        public MedianFinder() {
            smallH = new PriorityQueue<>((a, b) -> b - a);
            largeH = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            smallH.add(num);
            if (
                    smallH.size() - largeH.size() > 1 ||
                            !largeH.isEmpty() &&
                                    smallH.peek() > largeH.peek()
            ) {
                largeH.add(smallH.poll());
            }
            if (largeH.size() - smallH.size() > 1) {
                smallH.add(largeH.poll());
            }
        }

        public double findMedian() {
            if (smallH.size() == largeH.size()) {
                return (double) (smallH.peek() + largeH.peek()) / 2;
            } else if (smallH.size() > largeH.size()) {
                return (double) smallH.peek();
            } else {
                return (double) largeH.peek();
            }
        }
    }
}
