package pack;

import java.util.LinkedList;
import java.util.Map;

public class HashMapSimple<K, V> {
    private LinkedList<Entry<K, V>>[] arrLinkList;
    private int size = 0;
    /**
     * The capacity should be a prime number in order to avoid extra collisions
     */
    private final int ARRAY_CAPACITY_DEFAULT = 101;

    HashMapSimple() {
        arrLinkList = new LinkedList[ARRAY_CAPACITY_DEFAULT];
    }

    HashMapSimple(int capacity) {
        arrLinkList = new LinkedList[capacity];

    }

    /**
     * Consisting of two portions :
     * - A hash code that maps a key k to an integer
     *      - Object.hasCode() is quite efficient)
     * - A compression function that maps the hash code to an integer within a range of indices, [0, N − 1]
     *      - The division method is used (i mod N)
     * @param key
     * @return
     */
    private int hashFunction(K key) {
        return key.hashCode() % arrLinkList.length - 1;
    }

    public void put(K key, V value) {
        int hashResult = hashFunction(key);
        boolean inserted = false;
        if (arrLinkList[hashResult] == null) {
            arrLinkList[hashResult] = new LinkedList<>();
        }

        for (int i = 0; i < arrLinkList[hashResult].size(); i++) {
            if (arrLinkList[hashResult].get(i).getKey() == key) {
                arrLinkList[hashResult].get(i).setValue(value);
                inserted = true;
            }
        }

        if (!inserted) {
            arrLinkList[hashResult].add(new Entry<>(key, value));
            size++;
        }
    }

    public V get(K key) {
        int listSize = arrLinkList[hashFunction(key)].size();
        for (int i = 0; i < listSize; i++) {
            if (arrLinkList[hashFunction(key)].get(i).getKey() == key)
                return arrLinkList[hashFunction(key)].get(i).getValue();
        }
        return null;
    }

    public int size() {
        return size;
    }

    class Entry<K,V> implements Map.Entry<K,V> {
        private final K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return null;
        }
    }
}
