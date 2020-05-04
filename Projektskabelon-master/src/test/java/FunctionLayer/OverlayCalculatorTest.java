package FunctionLayer;

import DBAccess.MaterialMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverlayCalculatorTest {


    @Test
    public void countWoodLength() {
        int result = OverlayCalculator.countWoodLength(225);
        int expected = 240;
        assertEquals(expected, result);
    }


    @Test
    public void spaersNumberOnSide() {
        int result = OverlayCalculator.spaersNumberOnSide(9100, 2000, 17);
        System.out.println("Test SpearNumberOnSide: rsult= "+result);
        int expected= 10;
        assertEquals(result,expected);
    }

    @Test
    public void materials() {
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
        int result= OverlayCalculator.numberOfFyrOnDistance(6000);
        int expected = 9;
        assertEquals(expected,result);
    }

    @Test
    public void fyrNumberOnSide() {
        int result=OverlayCalculator.fyrNumberOnSide(9100);
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
        ArrayList<Integer> fyrLengths= OverlayCalculator.fyrLengths(2000,10,9100);
        int distance= ConstructionSizeCalculator.postDistanceMax3000(9100);
        int numberOfdistances= ConstructionSizeCalculator.sidePostAmount(9100)-1;
        int numberOfFyr= OverlayCalculator.numberOfFyrOnDistance(distance)*numberOfdistances;

        int lengthOfeight=fyrLengths.get(7);
        int expectedLength=ConstructionSizeCalculator.raising(10,5400)+2000-360;
        assertEquals(fyrLengths.size(),numberOfFyr);
        assertEquals(expectedLength,lengthOfeight);

    }


    @Test
    public void areal() {
        double actual=OverlayCalculator.areal(3300,5000, 3);
        double expected = 34.45;
        assertEquals(expected,actual, 0.01);
    }

    @Test
    public void overlaySpending() {
        int result;
        double spending=7.7;
        double actual = spending*34.52;
        actual=actual+0.05*actual; //5 % extra material for cuts

        if ( ((actual*10)%10) ==0 ){
            result= (int) actual;
        }
        else {
            result= (int) actual+1;
        }
        int expected = 280;
        assertEquals(result,expected);
    }
}