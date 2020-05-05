package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverlaySizeCalculatorTest {
    Construction construction = new Construction();


    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(7200);
        construction.setConstructionHeight(2000);
        construction.setCarportWidth(4200);
        Roof roof = new RoofFlat( 0, 7200+2900, 4200,3,false);
        construction.setRoof(roof);
        Shed shed = new Shed(4200/2,2900,"left");
        ArrayList<Wall> shedWalls= WallBuilder.addShedWalls(construction);
        shed.setWalls(shedWalls);
        String[] constructionWalls={"left","right"};
        ArrayList<Wall> carportWalls=WallBuilder.addCarportWalls(construction, constructionWalls);
    }

    @Test
    public void spaersNumberOnSide() {

    }

    @Test
    public void screwSpaer() {
    }

    @Test
    public void numberOfFyrOnDistance() {
    }

    @Test
    public void fyrNumberOnSide() {
    }

    @Test
    public void screwFyr() {
    }

    @Test
    public void fyrLengths() {
    }

    @Test
    public void overlaySpending() {
    }

    @Test
    public void areal() {
    }

    @Test
    public void allWallsAreal() {
    }

    @Test
    public void countWoodLength() {
    }
}