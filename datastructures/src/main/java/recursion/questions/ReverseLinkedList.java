package recursion.questions;


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

public class ReverseLinkedList {

    /**
     * https://leetcode.com/problems/reverse-linked-list/
     */
    //solution 1
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }
        ListNode temp = node.next;
        node.next = prev;
        return reverse(temp, node);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
       ListNode reversedHead = reverseLinkedList.reverseList2(head);
        while (reversedHead != null) {
            System.out.println(reversedHead.val);
            reversedHead = reversedHead.next;
        }
    }

}
