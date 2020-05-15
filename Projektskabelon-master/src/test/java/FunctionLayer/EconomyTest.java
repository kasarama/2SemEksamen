package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EconomyTest {
    public ArrayList<Material> tmp = new ArrayList<>();
    Order order = new Order();
    Construction construction = new Construction();
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

        construction.setCarportLength(5000);
        construction.setCarportWidth(4200);
        construction.setConstructionHeight(2000);
        construction.setShed(new Shed(0,0, ""));
        construction.setConstructionLength();
        construction.setConstructionWidth();

        order.setConstruction(construction);
    }

    @Test
    public void ordersCostPrice() {
        double actual = tmp.get(0).getPrice();
        double expected = 1000;
        assertEquals(expected, actual, 2);
    }

    @Test
    public void ordersCostPrice2() throws LoginSampleException {
        double actual = Economy.ordersCostPrice(order);
        double expected = 1000;
        assertEquals(expected, actual, 2);
    }

}