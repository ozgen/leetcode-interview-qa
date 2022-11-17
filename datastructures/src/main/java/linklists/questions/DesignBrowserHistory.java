package linklists.questions;


class DoublyNode {

    String val;
    DoublyNode next;
    DoublyNode prev;

    public DoublyNode(String val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class BrowserHistory {
    DoublyNode head;
    DoublyNode current;


    public BrowserHistory(String homepage) {
        DoublyNode node = new DoublyNode(homepage);
        head = node;
        current = head;
    }

    public void visit(String url) {
        DoublyNode node = new DoublyNode(url);
        current.next = node;
        node.prev = current;
        current = node;
    }

    public String back(int steps) {
        DoublyNode tmp = current;
        for (int i = 0; i < steps; i++) {
            if (tmp.prev != null) {
                tmp = tmp.prev;
            }
        }
        current = tmp;
        return current.val;
    }

    public String forward(int steps) {
        DoublyNode tmp = current;
        for (int i = 0; i < steps; i++) {
            if (tmp.next != null) {
                tmp = tmp.next;
            }
        }
        current = tmp;
        return current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

public class DesignBrowserHistory {

    /**
     * https://leetcode.com/problems/design-browser-history/
     */

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("leetcode");
        history.visit("google");
        history.visit("face");
        history.visit("youtube");
        System.out.println(history.back(1));

        System.out.println(history.back(1));

        System.out.println(history.forward(1));

        history.visit("linkedIn");
        System.out.println(history.forward(2));
        System.out.println(history.back(2));
        System.out.println(history.back(7));


    }
}
