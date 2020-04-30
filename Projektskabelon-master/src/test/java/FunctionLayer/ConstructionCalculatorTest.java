package FunctionLayer;
;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructionCalculatorTest {

    ConstructionCalculator c = new ConstructionCalculator();
    @Test
    public void posts() {
        int length = 480;
        int width = 510;
        int result = c.posts(length, width);
        int expected = 6;
        assertEquals(expected, result);
    }
    @Test
    public void posts2() {
        int length = 480;
        int width = 610;
        int result = c.posts(length, width);
        int expected = 6;
        assertEquals(expected, result);
    }

    @Test
    public void perforatedBand() {
    }

    @Test
    public void bracketScrewsCon() {
    }
}
