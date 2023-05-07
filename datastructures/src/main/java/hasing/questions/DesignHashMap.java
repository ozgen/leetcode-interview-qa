package hasing.questions;

public class DesignHashMap {
    /**
     * https://leetcode.com/problems/design-hashmap/description/
     */

    class MyHashMap {
        Node[] nodes;

        public MyHashMap() {
            nodes = new Node[1000];
        }

        public void put(int key, int value) {
            remove(key);
            int h = hash(key);
            Node n = new Node(value, key);
            n.next = nodes[h];
            nodes[h] = n;
        }

        public int get(int key) {
            int h = hash(key);
            Node n = nodes[h];
            while (n != null) {
                if (n.key == key) {
                    return n.val;
                }
                n = n.next;
            }
            return -1;
        }

        public void remove(int key) {
            int h = hash(key);
            Node node = nodes[h];
            if (node == null){
                return;
            }
            if (node.key == key){
                nodes[h] = node.next;
            }
            else{
                while(node.next != null){
                    if (node.next.key == key) {
                        node.next = node.next.next;
                        return;
                    }
                    node = node.next;
                }
            }
        }

        private int hash(int key) {
            return key % nodes.length;
        }
    }

    class Node {
        int val;
        int key;
        Node next;

        public Node(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
}
