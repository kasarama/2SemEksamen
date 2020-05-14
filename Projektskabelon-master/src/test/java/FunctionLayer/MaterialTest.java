package FunctionLayer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialTest {

    @Test
    public void testEquals() {
        Material m1 = new Material("dog", 100, 0, "pk.", 0, "roof");
        Material m4 = new Material("horse", 110, 0, "pk.", 0, "door");
        Material m5 = new Material("dog", 100, 0, "pk.", 0, "roof");
        Material m7 = new Material("dog", 100, 10, "m", 10, "roof");

        assertTrue(m1.equals(m5));
        assertTrue(!m1.equals(m4));
        assertTrue(!m1.equals(m7));
    }
}