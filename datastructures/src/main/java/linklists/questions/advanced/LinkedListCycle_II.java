package linklists.questions.advanced;

import linklists.single.ListNode;

public class LinkedListCycle_II {
    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */

    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (s == f) {
                break;
            }
        }
        if (f == null || f.next == null) return null;

        ListNode s2 = head;
        while (s2 != s) {
            s2 = s2.next;
            s = s.next;
        }
        return s2;

    }
}
