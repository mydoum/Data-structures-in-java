package pack;

import java.util.LinkedList;

public class HashMapSimple<K, V> {
    private LinkedList<V>[] arrLinkList;
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
        return key.hashCode() % arrLinkList.length;
    }

    public void put(K key, V value) {
        LinkedList<V> l = new LinkedList<>();
        l.add(value);
        arrLinkList[hashFunction(key)] = l;
    }

    public V get(K key) {
        return arrLinkList[hashFunction(key)].getFirst();
    }
}
