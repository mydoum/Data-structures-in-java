import java.util.LinkedList;

/**
 * Created by alonso on 02/10/16.
 */
public class HashTableSimple<K, V> {
    private LinkedList<V>[] arrLinkList;

    HashTableSimple() {
        arrLinkList = new LinkedList[200000];
    }

    public void put(K key, V value) {
        LinkedList<V> l = new LinkedList<>();
        l.add(value);
        arrLinkList[key.hashCode() % arrLinkList.length] = l;
    }

    public V get(K key) {

        return arrLinkList[key.hashCode() % arrLinkList.length].getFirst();
    }
}
