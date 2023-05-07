package hasing.questions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * https://leetcode.com/problems/lru-cache/
     */
    Map<Integer, Node> cache;
    int cap;

    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap =capacity;
        cache = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size()>cap){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(Node node){
        Node prev = right.prev;
        Node next = right;

        prev.next = node;
        node.next = next;

        node.prev = prev;
        next.prev = node;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    class Node {
        int val;
        int key;

        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
