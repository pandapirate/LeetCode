package Other;

import java.util.HashMap;

/**
 * Created by khuang on 8/26/14.
 */
public class LRUCache {
    private class Node {
        public int val;
        public int key;
        public Node next;
        public Node prev;
        public Node(int keys, int value) {key = keys; val = value;}
    }

    final int maxSize;
    int counter;
    Node head, tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        maxSize = capacity;
        counter = 0;
        head = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            System.out.println(map.get(key).val);
            return map.get(key).val;
        }
        System.out.println(-1);
        return -1;
    }

    public void set(int key, int value) {
        if (head == null) {
            head = new Node(key, value);
            map.put(key, head);
            counter++;
        } else {
            if (map.containsKey(key)) {
                // move to front
                Node node = map.get(key);
                node.val = value; // set the value first

                if (node.prev != null) {
                    node.prev.next = node.next;
                }

                if (node == tail) {
                    tail = tail.prev;
                }

                if (node != head) {
                    node.prev = null;
                    node.next = head;
                    head.prev = node;
                    head = node;
                }


            } else {
                if (counter < maxSize) {
                    // add new node to the front
                    counter++;
                    Node node = new Node(key, value);
                    map.put(key, node);
                    node.next = head;
                    head.prev = node;
                    head = node;

                    if (counter == maxSize) {
                        Node temp = head;
                        while (temp.next != null) {
                            temp = temp.next;
                        }
                        tail = temp;
                    }
                } else {
                    //bump the last one
                    Node node = new Node(key, value);
                    map.put(key, node);
                    node.next = head;
                    head.prev = node;
                    head = node;

                    if (tail != null && tail.prev != null) {
                        tail.prev.next = null;
                        map.remove(tail.key);
                        tail = tail.prev;

                    }
                }
            }
        }
    }

    public static void main(String args[]) {

    }
}
