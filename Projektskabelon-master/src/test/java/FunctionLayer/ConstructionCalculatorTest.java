package FunctionLayer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    public void perforatedBand() {
    }

    @Test
    public void bracketScrewsCon() {
    }
}
