package linklists.questions;

public class ReverseLinkedList {

    /**
     * https://leetcode.com/problems/reverse-linked-list/
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reversedHead = reverseLinkedList.reverseList(head);
        while (reversedHead!=null){
            System.out.println(reversedHead.val);
            reversedHead = reversedHead.next;
        }
    }
}
