import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequent {

    /**
     * https://leetcode.com/problems/top-k-frequent-elements/
     */

    /**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(n)
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) ->
                        a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k) pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] topKFrequentSolution1(int[] numbers, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers)
            map.put(
                    number,
                    map.getOrDefault(number, 0) + 1
            );

        int size = map.size();
        int[] keys = new int[size];
        int i = 0;
        for (int key : map.keySet()) keys[i++] = key;

        select(keys, map, 0, size - 1, size - k);
        return Arrays.copyOfRange(keys, size - k, size);
    }

    // Modified implementation of Hoare's selection algorithm:

    private static void select(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int kSmallest
    ) {
        while (left != right) {
            int pivot = partition(keys, map, left, right, (left + right) / 2);

            if (kSmallest == pivot) return;

            if (kSmallest < pivot) right = pivot - 1;
            else left = pivot + 1;
        }
    }

    private static int partition(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int pivot
    ) {
        int pivotValue = map.get(keys[pivot]);
        swap(keys, pivot, right);
        int index = left;

        for (int i = left; i <= right; i++)
            if (map.get(keys[i]) < pivotValue) {
                swap(keys, i, index);
                index++;
            }
        swap(keys, right, index);
        return index;
    }

    private static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static int[] topKfrequentSolution2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i : nums) {
            freq.merge(i, 1, Integer::sum);
        }

        return freq.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .mapToInt(i -> i)
                .toArray();
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6};
        int k = 2;
        int[] topk1 = topKFrequentSolution1(nums, k);
        Arrays.stream(topk1).forEach(System.out::println);
        System.out.println("------");
        int[] topk2 = topKFrequent(nums, k);
        Arrays.stream(topk2).forEach(System.out::println);
        System.out.println("------");
        int[] res = topKfrequentSolution2(nums, k);
        Arrays.stream(res).forEach(System.out::println);

    }
}
