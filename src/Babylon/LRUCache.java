package Babylon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key; int val; Node next; Node prev;
        Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cacheMap;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node = cacheMap.get(key);
        remove(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.val = value;
            remove(node);
            addFirst(node);
            return;
        }

        Node node = new Node(key, value);
        cacheMap.put(key, node);
        addFirst(node);
        if (cacheMap.size() > capacity) {
            Node last = tail.prev;
            remove(last);
            cacheMap.remove(last.key);
        }
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addFirst(Node node) {

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
