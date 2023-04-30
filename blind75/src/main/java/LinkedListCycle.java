public class LinkedListCycle {
    /**
     * https://leetcode.com/problems/linked-list-cycle/
     */
    public class ListNode {
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

    public boolean hasCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
            if (s == f) {
                return true;
            }
        }
        return false;
    }
}
