package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShedSizingTest {

    CarportRequest carportRequest = new CarportRequest(780,720,0,0,0);
    ArrayList depths = new ArrayList();
    @Before
    public void setUp() throws Exception {

        int maxDepth = carportRequest.getLength()-440-15;
        for (int i = 10; i <=maxDepth/10; i++) {
            depths.add(i*10);
        }
    }

    @Test
    public void backShedDepth() {
        for (int i = 0; i < depths.size(); i++) {
            System.out.println(depths.get(i));
        }
        assertEquals(320, depths.get(depths.size()));

    }

}