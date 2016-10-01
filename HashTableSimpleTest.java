import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class HashTableSimpleTest {

    private HashTableSimple<String, Integer> myHash;

    @Before
    public void before() throws Exception {
        myHash = new HashTableSimple<>();
    }

    @Test
    public void testPut() throws Exception {
        myHash.put("hello", 3);
        assertEquals(3, (int)myHash.get("hello"));
    }

    @Test
    public void testGet() throws Exception {

    }
}
