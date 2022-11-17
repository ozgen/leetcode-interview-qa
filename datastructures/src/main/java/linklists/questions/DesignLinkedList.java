package linklists.questions;

class Node {

    int val;
    Node next;


    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    int length = 0;

    public MyLinkedList() {


    }

    public int get(int index) {
        if (index >= length)
            return -1;
        int counter = 0;
        Node temp = head;
        while (counter < index) {
            counter++;
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        length++;

    }

    public void addAtTail(int val) {
        if (head == null) addAtHead(val);
        else {
            Node node = new Node(val);
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
            length++;
        }
    }

    //(1,3) index 1-> 2
    public void addAtIndex(int index, int val) {
        if (index > length)
            return;

        if (index == 0)
            addAtHead(val);
        else if (index == length)
            addAtTail(val);
        else {
            Node temp = head;
            int count = 0;
            while (count != index - 1) {
                temp = temp.next;
                count++;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }


    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length)
            return;

        if(index == 0){
            Node temp = head.next;
            head = temp;
            length--;
        } else {
            int count = 0;
            Node pre = head;
            while(count != index-1){
                pre = pre.next;
                count++;
            }
            pre.next = pre.next.next;
            length--;
        }
    }
}

public class DesignLinkedList {

    /**
     * https://leetcode.com/problems/design-linked-list/
     */

    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();
        test.addAtHead(1);
        test.addAtTail(3);
        test.addAtIndex(2, 2);
        test.deleteAtIndex(1);
        System.out.println();

    }
}
