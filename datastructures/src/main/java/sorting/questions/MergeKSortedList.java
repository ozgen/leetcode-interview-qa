package sorting.questions;

import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {

    //  Solution using Min Heap
    //  Time Complexity:         O(n*log(k))
    //  Extra Space Complexity:  O(k)

    public ListNode mergeKLists1(ListNode[] lists) {
        Queue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode nodes : lists) {
            ListNode current = nodes;
            while (current != null) {
                minHeap.add(current.val);
                current = current.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.poll());
            current = current.next;
        }

        return dummy.next;
    }

    //  Solution using Iterative Merge Sort
    //  Time Complexity:         O(n*log(k))
    //  Extra Space Complexity:  O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        int interval = 1;

        while (interval < size) {
            for(int i = 0; i<size-interval; i+= 2*interval){
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval*=2;
        }
        return size > 0 ? lists[0] : null;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (node1 != null && node2 != null) {
            if(node1.val<= node2.val){
                current.next = node1;
                node1 = node1.next;
            }else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        if (node1 != null) {
            current.next = node1;
        } else {
            current.next = node2;
        }
        return dummy.next;
    }
}
