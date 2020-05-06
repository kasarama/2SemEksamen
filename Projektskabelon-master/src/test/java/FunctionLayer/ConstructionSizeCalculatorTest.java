package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructionSizeCalculatorTest {
Construction construction = new Construction();
ConstructionSizeCalculator constructionSizeCalculator = new ConstructionSizeCalculator();


    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(9100);
        construction.setCarportWidth(12300);
        Shed shed = new Shed((construction.getCarportWidth()/2),7600,"left");
        construction.setShed(shed);
        Roof pitchedRoof = new RoofFlat(construction.getConstructionHeight(), construction.getConstructionLength(),
                construction.getConstructionWidth());
        pitchedRoof.setDegree(3);
        construction.setRoof(pitchedRoof);


    }


    @Test
    public void postRows() {
        int rows= ConstructionSizeCalculator.postRows(construction.getCarportWidth());
        assertEquals(4,rows);
    }


    @Test
    public void sidePostAmount() {
        int actual= ConstructionSizeCalculator.sidePostAmount(8500);
        int expected = 4;
        assertEquals(expected,actual);
    }

    @Test
    public void postDistanceMax300() {
        int actual= ConstructionSizeCalculator.postDistanceMax3000(8600);
        int exp =2833;
        assertEquals(exp,actual);

    }

    @Test
    public void shedFrontPostsAmount() {
        int actual = ConstructionSizeCalculator.shedFrontPostsAmount(1400);
        int expected=2;
        assertEquals(expected,actual);
    }


    @Test
    public void postsHeights() {
        Integer[]heights= ConstructionSizeCalculator.postsHeights(2000,3,7200);

        int result = heights[3];
        assertEquals(2210,result);
        /*
        distance mellem stolper: 2366,7 og det svarer til 2366 som int
        højde stiger 70,98 mm dvs 70 som int
        1: 2000 (idex 0)
        2:2070 (idex 1)
        3:2140
         */
    }


    @Test
    public void raising() {
        double actual=ConstructionSizeCalculator.raising(8,9750);
        double expected=780;
        assertEquals(expected,actual,0.01);

    }

    @Test
    public void carportMinHeight() {
        int minH = ConstructionSizeCalculator.carportMinHeight(2000, construction.getShed().getDepth(),3);
        int exp =2228;
        assertEquals(exp,minH);
    }
}