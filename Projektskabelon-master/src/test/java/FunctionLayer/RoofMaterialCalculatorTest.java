package FunctionLayer;

import PresentationLayer.FlatRoof;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class RoofMaterialCalculatorTest {

    Construction con = new Construction();;
    RoofSizing rs = new RoofSizing(con);
    Roof roof;
    RoofMaterialCalculator rmc = new RoofMaterialCalculator();

    @Test
    public void quantityOfT600ForRoofFlatRoof() {
        //Arrange
        con.setConstructionLength(1500);
        con.setConstructionWidth(350);

        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth());
        con.setRoof(roof);
        int roofHeigth = rs.roofHeight(con.getRoof().getIsPitched());
        con.getRoof().setHeight(roofHeigth);
        int roofWidthSurface = rs.roofWidthSurface();
        int roofLengthSurface = rs.roofLengthSurface();
        //Act
        int actual = rmc.quantityOfT600ForRoof(roofWidthSurface, roofLengthSurface, con.getRoof().getIsPitched());
        int expected = 7;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void quantityOfT300ForRoof() {
    }

    @Test
    public void understernboartU360() {
    }

    @Test
    public void understernboartU540() {
    }

    @Test
    public void oversternboartU360() {
    }

    @Test
    public void oversternboartU540() {
    }

    @Test
    public void rem600() {
    }

    @Test
    public void rem480() {
    }

    @Test
    public void raft() {
    }

    @Test
    public void vandbræt360() {
    }

    @Test
    public void vandbræt540() {
    }

    @Test
    public void gasket() {
    }

    @Test
    public void bottomScrews() {
    }

    @Test
    public void universalBracketsRight() {
    }

    @Test
    public void universalBracketsLeft() {
    }

    @Test
    public void bracketScrewsRoof() {
    }

    @Test
    public void carriageBolts() {
    }

    @Test
    public void squares() {
    }
}
