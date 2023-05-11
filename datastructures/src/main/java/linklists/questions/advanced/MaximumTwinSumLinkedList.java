package linklists.questions.advanced;

import linklists.single.ListNode;

public class MaximumTwinSumLinkedList {

    /**
     * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
     */

    public int pairSum(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        ListNode prev = null;

        while (f != null && f.next != null) {
            f = f.next.next;

            ListNode tmp = s.next;
            s.next = prev;
            prev = s;
            s = tmp;
        }

        int res = 0;

        while (s != null) {
            res = Math.max(res, prev.val + s.val);
            s = s.next;
            prev = prev.next;
        }
        return res;
    }
}
