package FunctionLayer;

import PresentationLayer.Overlay;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverlayCalculatorTest {

    int numberOfPost;
    Carport carport = new Carport();


    @Before
    public void setUp() throws Exception {
        carport.setLength(910);
        carport.setWidth(1230);
        Shed shed = new Shed((carport.getWidth()/2),460,"left");
        carport.setShed(shed);

    }


    @Test
    public void countWoodLength() {
        int result = OverlayCalculator.countWoodLength(225);
        int expected = 240;
        assertEquals(expected, result);
    }





    @Test
    public void sideSpaers() {
        Roof roof = new Roof();
        roof.setDegree(50);
        Shed shed = new Shed((carport.getWidth()/2),860,"left");
        carport.setRoof(roof);

    }

    @Test
    public void sideSpaer() {
        int result = OverlayCalculator.sideSpaer(1100, 200, 22,false);
        int expected= 14;
    }
}