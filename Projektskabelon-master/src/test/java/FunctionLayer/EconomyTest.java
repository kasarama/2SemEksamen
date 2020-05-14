package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EconomyTest {
    public ArrayList<Material> tmp = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        Material rem = new Material();
        rem.setPrice(1000);
        rem.setId(1);
        tmp.add(rem);
        Material spær = new Material();
        spær.setPrice(2000);
        spær.setId(2);
        tmp.add(spær);
    }

    @Test
    public void ordersCostPrice() {
        double actual = tmp.get(1).getPrice();
        double expected = 1000;
        assertEquals(expected, actual);
    }

}