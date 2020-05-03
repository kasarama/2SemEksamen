package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        int result = OverlayCalculator.spaersNumberOnSide(910, 200, 17);
        int expected= 10;
    }

    @Test
    public void materials() {

        for (Material ma: OverlayCalculator.wallMaterials(construction.getShed().getWalls())
             ) {

        }
    }



    @Test
    public void materialList() {
    }

    @Test
    public void materialsForWall() {
    }



    @Test
    public void screwSpaer() {
        int result = OverlayCalculator.screwSpaer(10);
        int expected = 40;
        assertEquals(expected,result);
    }

    @Test
    public void numberOfFyrOnDistance() {
        int result= OverlayCalculator.numberOfFyrOnDistance(600);
        int expected = 9;
        assertEquals(expected,result);
    }

    @Test
    public void fyrNumberOnSide() {
        int result=OverlayCalculator.fyrNumberOnSide(910);
        int expected = 12;
        assertEquals(expected,result);

    }

    @Test
    public void screwFyr() {
        int expected=12*10; //OverlayCalculator.fyrNumberOnSide(910)*OverlayCalculator.spaersNumberOnSide(910,200,17);
        int actual = OverlayCalculator.screwFyr(12,10); //;
        assertEquals(expected,actual);
    }

    @Test
    public void FyrLengths() {
        ArrayList<Integer> fyrLengths= OverlayCalculator.fyrLengths(200,10,910);
        int distance= ConstructionSizeCalculator.postDistanceMax300(910);
        int numberOfdistances= ConstructionSizeCalculator.sidePostAmount(910)-1;
        int numberOfFyr= OverlayCalculator.numberOfFyrOnDistance(distance)*numberOfdistances;

        int lengthOfeight=fyrLengths.get(7);
        int expectedLength=ConstructionSizeCalculator.raising(10,540)+200;
        assertEquals(fyrLengths.size(),numberOfFyr);
        assertEquals(expectedLength,lengthOfeight);

    }


    @Test
    public void testCountWoodLength() {
    }
}