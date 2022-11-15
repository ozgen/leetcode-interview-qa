package linklists.questions;

public class MergeTwoSortedList {

    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode start = new ListNode(-1);
        ListNode cur = start;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode mergedList = mergeTwoSortedList.mergeTwoLists(head, head2);
        while (mergedList!=null){
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }
}
