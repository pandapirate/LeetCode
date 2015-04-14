package HashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NewHashMap<K, V> {

    private int size = 100;
    private Entry<K, V>[] list = new Entry[size];

    public NewHashMap() {
    }

    public void put (K key, V value) {
        int i = indexOfKey(key);
        if (i >= 0) {
            list[i].value = value;
        } else {
            int pos = findNullPosition();
            list[pos] = new Entry<K, V>(key, value);
        }
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    public V getValueForKey(K key) {
        int index = indexOfKey(key);
        if (index >= 0) {
            return list[index].value;
        } else {
            return null;
        }
    }

    public Set<K> getKeySet() {
        Set<K> keyList = new HashSet<K>();
        for (int i = 0; i < size; i++) {
            if (list[i] != null) {
                keyList.add(list[i].key);
            }
        }

        return keyList;
    }

    public void remove(K key) {
        int index = indexOfKey(key);
        if (index >= 0)
            list[index] = null;
    }

    public int size() {
        return getKeySet().size();
    }

    private int findNullPosition() {
        for (int i = 0; i < size; i++) {
            if (list[i] == null) {
                return i;
            }
        }
        int temp = size;
        expandArray();

        return temp;
    }

    private void expandArray() {
        size *= 2;
        list = Arrays.copyOf(list, size);
    }

    private int indexOfKey (K key) {
        for (int i = 0; i < size; i++) {
            if (list[i] == null)
                continue;

            if (list[i].key.equals(key))
                return i;
        }
        return -1;
    }

    public class Entry<K, V> {
        public final K key;
        public V value;

        public Entry (K k, V v) {
            key = k;
            value = v;
        }
    }
}
