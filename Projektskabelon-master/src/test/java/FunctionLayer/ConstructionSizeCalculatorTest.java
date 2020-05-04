package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructionSizeCalculatorTest {
Construction construction = new Construction();
ConstructionSizeCalculator constructionSizeCalculator = new ConstructionSizeCalculator();


    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(910);
        construction.setCarportWidth(1230);
        Shed shed = new Shed((construction.getCarportWidth()/2),760,"left");
        construction.setShed(shed);
        Roof pitchedRoof = new RoofFlat(construction.getConstructionHeight(), construction.getConstructionLength(),
                construction.getConstructionWidth());
        pitchedRoof.setDegree(3);
        construction.setRoof(pitchedRoof);


    }


    //TODO - denne test er unødvendig
    /*@Test
    public void doubleTOint() {
        double a = 2.75;
        int b = (int) a;
        assertEquals(3,b);

    }*/



    @Test
    public void postRows() {
        int rows= ConstructionSizeCalculator.postRows(construction.getCarportWidth());
        assertEquals(4,rows);
    }


    @Test
    public void sidePostAmount() {
        int actual= ConstructionSizeCalculator.sidePostAmount(850);
        int expected = 4;
        assertEquals(expected,actual);
    }

    @Test
    public void postDistanceMax300() {
        int actual= ConstructionSizeCalculator.postDistanceMax300(850);
        int exp =280;
    }

    @Test
    public void shedFrontPostsAmount() {
        int actual = ConstructionSizeCalculator.shedFrontPostsAmount(1400);
        int expected=5;
    }

    @Test
    public void shedFrontSidePostDistance() {
    }

    @Test
    public void postsHeights() {
        Integer[]heights= ConstructionSizeCalculator.postsHeights(200,0,500);
        int rsult = heights[1];
        assertEquals(200,rsult);
    }

}