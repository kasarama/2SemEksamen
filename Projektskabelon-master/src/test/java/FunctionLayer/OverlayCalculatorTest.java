package FunctionLayer;

import PresentationLayer.Overlay;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverlayCalculatorTest {

    int numberOfPost;
    Carport carport = new Carport();
    Shed shed = new Shed((carport.getWidth()/2),460,"left");
    Roof roof = new Roof();

    @Before
    public void setUp() throws Exception {
        carport.setLength(910);
        carport.setWidth(1230);
        carport.setShed(shed);
        roof.setDegree(3);
        carport.setRoof(roof);
        shed.setWalls(WallBuilder.addShedWalls(carport));
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
    public void spaersNumberOnSide() {
        int result = OverlayCalculator.spaersNumberOnSide(1100, 200, 22);
        int expected= 14;
    }

    @Test
    public void materials() {
        System.out.println("there is "+ OverlayCalculator.Materials(carport.getShed().getWalls()).size()+" materials on the list");
        for (Material ma: OverlayCalculator.Materials(carport.getShed().getWalls())
             ) {
            System.out.println(ma.getName());
        }
    }
}