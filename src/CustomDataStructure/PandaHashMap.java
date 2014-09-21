package CustomDataStructure;

import java.util.*;

/**
 * Created by khuang on 9/20/14.
 */
public class PandaHashMap<K, V> implements Map<K,V> {

    private double loadFactor = 0.75;
    private int count;
    private int size;
    private Entry<K,V>[] map;

    public PandaHashMap() {
        count = 0;
        size = 8;
        map = new Entry[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        // TODO
        return false;
    }

    @Override
    public V get(Object key) {
        return getEntry((K)key).getValue();
    }

    @Override
    public V put(K key, V value) {
        Entry<K,V> exist = getEntry(key);
        if (exist == null) {
            int hash = hashKey(key);
            Entry<K,V> newEntry = new Entry<>(key, value);
            Entry<K,V> location = map[hash];
            if (location == null) {
                //brand new in the bucket
                map[hash] = newEntry;
            } else {
                //go to the end of the bucket first
                while (location.next != null) {
                    location = location.next;
                }
                location.next = newEntry;
            }
            count++;
            if (count*1.0/size > loadFactor) {
                resize();
            }
            return null;
        } else {
            //repace value and return old value
            V oldVal = exist.getValue();
            exist.setValue(value);
            return oldVal;
        }
    }

    @Override
    public V remove(Object key) {
        int hash = hashKey((K)key);
        Entry<K,V> cur = map[hash];

        if (cur != null) {
            if (cur.getKey().equals(key)) {
                //first item in the chain
                map[hash] = cur.next;
                return cur.getValue();
            } else {
                while (cur != null) {
                    Entry<K,V> next = cur.next;
                    if (next != null && next.getKey().equals(key)) {
                        //first item in the chain
                        cur.next = next.next;
                        return next.getValue();
                    }
                    cur = next;
                }
            }
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (K key : m.keySet()) {
            put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        count = 0;
        size = 8;
        map = new Entry[size];
    }

    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (Entry<K, V> e : map) {
            Entry<K, V> ee = e;
            while (ee != null) {
                keySet.add(ee.getKey());
                ee = ee.next;
            }
        }
        return keySet;
    }

    @Override
    public Collection<V> values() {
        List<V> valList = new ArrayList<>();
        for (Entry<K, V> e : map) {
            Entry<K, V> ee = e;
            while (ee != null) {
                valList.add(ee.getValue());
                ee = ee.next;
            }
        }
        return valList;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> entrySet = new HashSet<>();
        for (Entry<K, V> e : map) {
            Entry<K, V> ee = e;
            while (ee != null) {
                entrySet.add(ee);
                ee = ee.next;
            }
        }
        return entrySet;
    }

    private Entry<K, V> getEntry(K key) {
        int hash = hashKey(key);

        Entry<K, V> e = map[hash];
        while (e != null) {
            if (e.getKey().equals(key)) {
                return e;
            } else if (e.next != null) {
                e = e.next;
            }
        }
        return null;
    }

    private int hashKey(K key) {
        return key.hashCode() % size;
    }

    private void resize() {
        System.out.println("Size at " + size + " Begin Resizing");
        size *= 2;
        Entry<K,V>[] newMap = new Entry[size];

        for (Entry<K, V> e : map) {
            Entry<K, V> ee = e;
            while (ee != null) {
                int hash = hashKey(ee.getKey());
                Entry<K,V> location = newMap[hash];
                if (location == null) {
                    //brand new in the bucket
                    newMap[hash] = ee;
                } else {
                    //go to the end of the bucket first
                    while (location.next != null) {
                        location = location.next;
                    }
                    location.next = ee;
                }
                ee = ee.next;
            }
        }
        map = newMap;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (Entry<K, V> e : map) {
            Entry<K, V> ee = e;
            while (ee != null) {
                str.append(ee.getKey() + "->'" + ee.getValue() + "', ");
                ee = ee.next;
            }
        }
        if (!isEmpty()) {
            String results = str.toString().substring(0, str.length()-2);
            return results + "]";
        }
        return "[]";
    }

    private class Entry<K, V> implements Map.Entry<K,V> {
        private K key;
        private V val;
        public Entry<K,V> next;

        public Entry(K k, V v) {
            key = k;
            val = v;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return val;
        }

        @Override
        public V setValue(V value) {
            V old = val;
            val = value;
            return old;
        }

        @Override
        public boolean equals(Object o) {
            if (o.getClass().equals(this.getClass())) {
                K oKey = ((Entry<K, V>) o).getKey();
                V oVal = ((Entry<K, V>) o).getValue();

                return oKey.equals(key) && oVal.equals(val);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ val.hashCode();
        }
    }
}
