package FunctionLayer;

import PresentationLayer.FlatRoof;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PostCalculatorTest {
Carport carport = new Carport();


    @Before
    public void setUp() throws Exception {
        carport.setLength(910);
        carport.setWidth(1230);
        Shed shed = new Shed((carport.getWidth()/2),760,"left");
        carport.setShed(shed);
        Roof roof = new Roof();
        roof.setDegree(3);
        carport.setRoof(roof);


    }

    @Test
    public void doubleTOint() {
        double a = 2.75;
        int b = (int) a;
        assertEquals(3,b);

    }



    @Test
    public void postRows() {
        int rows= PostCalculator.postRows(carport.getWidth());
        assertEquals(4,rows);
    }


    @Test
    public void sidePostAmount() {
        int actual=PostCalculator.sidePostAmount(850);
        int expected = 4;
        assertEquals(expected,actual);
    }

    @Test
    public void postDistanceMax300() {
        int actual=PostCalculator.postDistanceMax300(850);
        int exp =280;
    }

    @Test
    public void shedFrontPostsAmount() {
        int actual = PostCalculator.shedFrontPostsAmount(1400);
        int expected=5;
    }

    @Test
    public void shedFrontSidePostDistance() {
    }
}