package FunctionLayer;

import PresentationLayer.FlatRoof;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class PitchedRoofMaterialCalculatorTest {

    Construction con = new Construction();
    PitchedRoofMaterialCalculator prc = new PitchedRoofMaterialCalculator(con);
    RoofSizing rs = new RoofSizing(con);
    Roof roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 35);

    @Before
    public void setUp() throws Exception {
        //Arrange
    //    con.setConstructionWidth(2400);
      //  con.setConstructionLength(3600);
        con.setRoof(roof);
        con.setCarportWidth(con.getConstructionWidth()-150);
        con.setCarportLength(con.getConstructionLength()-15);
    }

    @Test
    public void gavlOverlayQuantityTest() {
        //Arrange
        int roofHeight = rs.roofHeight(con.getRoof().getIsPitched(),con.getConstructionLength(),con.getConstructionWidth());
        con.getRoof().setHeight(roofHeight);
        int widthOverlayPlank = 100;
        int lengthOverlayPlank = 2400;
        //Act
        int atual = prc.gavlOverlayQuantity(widthOverlayPlank, lengthOverlayPlank);
        int expected = 3 ;
        //Assert
        assertEquals(expected, atual);
    }

    @Test
    public void amoutOfRygstenBeslagCalculated() {

    }

    @Test
    public void amountOfTagsten() {
    }

    @Test
    public void tagstenBindereCalculated() {
    }

    @Test
    public void tagstenNakkekrogeCalculated() {
    }

    @Test
    public void screwForTaglægterCalculated() {
    }

    @Test
    public void screwsForVindskederCalculated() {
    }

    @Test
    public void screwsForVandbrætCalculated() {
    }

    @Test
    public void amountOfBeslagScrewsForToplægteCalculated() {
    }

    @Test
    public void spærBrædtLængdePrSpær() {
    }

    @Test
    public void spærAntal() {
    }

    @Test
    public void spærFuldeAntalBrædder() {
    }

    @Test
    public void rygsten() {
    }

    @Test
    public void numberOfStern() {
    }

    @Test
    public void numberOfT1_RygstenLength() {
    }

    @Test
    public void numberOfTagfodsLaegte() {
    }

    @Test
    public void numberOfVindskeder() {
    }

    @Test
    public void numberOfVandbraet() {
    }
}
