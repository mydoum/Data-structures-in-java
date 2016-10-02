package pack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class HashMapSimpleTest {

    private HashMapSimple<String, Integer> myHash;

    @Before
    public void before() throws Exception {
        myHash = new HashMapSimple<>();
    }

    /**
     *
     * Method: put(K key, V value)
     *
     */
    @Test
    public void testPut() throws Exception {
        myHash.put("hello", 3);
        assertEquals(3, (int)myHash.get("hello"));
    }

    /**
     *
     * Method: get(K key)
     *
     */
    @Test
    public void testGet() throws Exception {
        myHash.put("FB", 28);
        myHash.put("Ea", 54);
        assertEquals(54, (int)myHash.get("Ea"));
    }

    /**
     *
     * Method: size()
     *
     */
    @Test
    public void testSize() throws Exception {
        assertEquals(0, myHash.size());
        myHash.put("hello", 3);
        assertEquals(1, myHash.size());
        myHash.put("hello", 5);
        assertEquals(1, myHash.size());
    }
}