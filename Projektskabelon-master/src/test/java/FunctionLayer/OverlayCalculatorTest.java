package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverlayCalculatorTest {

    int numberOfPost;
    Construction construction = new Construction();
    Shed shed = new Shed((construction.getCarportWidth()/2),460,"left");
    Roof roof = new Roof();

    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(910);
        construction.setCarportWidth(1230);
        construction.setShed(shed);
        roof.setDegree(3);
        construction.setRoof(roof);
        shed.setWalls(WallBuilder.addShedWalls(construction));
        construction.setShed(shed);

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
        Shed shed = new Shed((construction.getCarportWidth()/2),860,"left");
        construction.setRoof(roof);

    }

    @Test
    public void spaersNumberOnSide() {
        int result = OverlayCalculator.spaersNumberOnSide(1100, 200, 22);
        int expected= 14;
    }

    @Test
    public void materials() {
        System.out.println("there is "+ OverlayCalculator.Materials(construction.getShed().getWalls()).size()+" materials on the list");
        for (Material ma: OverlayCalculator.Materials(construction.getShed().getWalls())
             ) {
            System.out.println(ma.getName());
        }
    }
}