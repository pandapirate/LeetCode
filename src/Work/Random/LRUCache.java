package Random;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    public static void main(String args[]) throws Exception {
        Cache c = new Cache(3);

        c.set(1, 1);
        c.set(2, 2);
        c.set(3, 3);
        c.print();
        c.set(1, 1);
        c.print();
        c.set(4, 4);
        c.set(5, 5);
        c.print();
    }

    public static class Cache {

        ArrayList<Integer> list;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n;

        public Cache(int capacity) {
            n = capacity;
            list = new ArrayList<Integer>();
        }

        public int get(int key) {
            if (map.containsKey(key))
                return map.get(key);
            else
                return -1;
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                int index = list.indexOf(key);
                list.remove(index);
                list.add(0, key);
            } else {
                list.add(0, key);
                map.put(key, value);
                if (list.size() > n) {
                    int removed = list.remove(list.size()-1);
                    map.remove(removed);
                }
            }
        }

        public void print() {
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            for (int i : list) {
                System.out.println(i + " - " + map.get(i));
            }
        }
    }
}
