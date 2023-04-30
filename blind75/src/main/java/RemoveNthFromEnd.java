public class RemoveNthFromEnd {
    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode f = tmp;
        ListNode s = tmp;
        while (n>0){
            s = s.next;
            n--;
        }
        while (s.next != null){
            f = f.next;
            s = s.next;
        }
        f.next = f.next.next;
        return tmp.next;
    }
}
