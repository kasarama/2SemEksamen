package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PitchedRoofMaterialCalculatorTest {

    Construction con = new Construction();
    PitchedRoofMaterialCalculator prc = new PitchedRoofMaterialCalculator(con);
    RoofSizing rs = new RoofSizing(con);
    Roof roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 35);

    @Before
    public void setUp() throws Exception {
        //Arrange
        con.setRoof(roof);
        con.setCarportWidth(24000-300);
        con.setCarportLength(36000);
        con.setCarportLength();
        con.getConstructionLength();
    }

    @Test
    public void gavlOverlayQuantityTest() {
        //Arrange
        int roofHeight = rs.roofHeight(con.getRoof().getIsPitched(),con.getConstructionLength(),con.getConstructionWidth());
        con.getRoof().setHeight(roofHeight);
        int widthOverlayPlank = 1000;
        int lengthOverlayPlank = 24000;
        //Act
        int atual = prc.gavlOverlayQuantity(widthOverlayPlank, lengthOverlayPlank);
        int expected = 3 ;
        //Assert
        assertEquals(expected, atual);
    }
}
