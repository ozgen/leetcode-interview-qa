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

    public ListNode reverseList2(ListNode head) {
        return rev(head, null);
    }

    public ListNode rev(ListNode node, ListNode pre) {
        if (node == null) return pre;
        ListNode temp = node.next;
        node.next = pre;
        return rev(temp, node);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        ListNode reversedHead = reverseLinkedList.reverseList(head);
        ListNode reversedHead2 = reverseLinkedList.reverseList2(head);
//        while (reversedHead!=null){
//            System.out.println(reversedHead.val);
//            reversedHead = reversedHead.next;
//        }
        while (reversedHead2!=null){
            System.out.println(reversedHead2.val);
            reversedHead2 = reversedHead2.next;
        }
    }
}
