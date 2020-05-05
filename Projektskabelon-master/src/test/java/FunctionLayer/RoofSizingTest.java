package FunctionLayer;

import PresentationLayer.FlatRoof;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RoofSizingTest {

    Construction con = new Construction();
    RoofSizing rs = new RoofSizing(con);
    Roof roof;

    //TODO - Husk Negative Test

    @Test
    public void roofFlatHeight() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofFlat(0,con.getConstructionLength(), con.getConstructionWidth());
        con.setRoof(roof);
        //Act
        int actuel = rs.roofHeight(con.getRoof().getIsPitched());
        int expected = 27;
        //Assert
                assertEquals(expected, actuel);

    }

    @Test
    public void roofPitchedHeight() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 30);
        con.setRoof(roof);
        //Act
        int actuel = rs.roofHeight(con.getRoof().getIsPitched());
        int expected = 103;
        //Assert
        assertEquals(expected, actuel);

    }

    //Er denne nødvendig?
    @Test
    public void roofWidthSurfaceFlatRoof() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofFlat(0,con.getConstructionLength(), con.getConstructionWidth());
        con.setRoof(roof);
        //Act
        int actuel = rs.roofWidthSurface();
        int expected = 360;
        //Assert
        assertEquals(expected, actuel);
    }


    @Test
    public void roofWidthSurfacePitchedRoof() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 30);
        con.setRoof(roof);
        //Act
        int actuel = rs.roofWidthSurface();
        int expected = 207;
        //Assert
        assertEquals(expected, actuel);
    }


    @Test
    public void roofLengthSurfaceFlatRoof() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofFlat(0,con.getConstructionLength(), con.getConstructionWidth());
        con.setRoof(roof);
        //Act
        int actuel = rs.roofLengthSurface();
        int expected = 780;
        //Assert
        assertEquals(expected, actuel);
    }

    //Er denne nødvendig?
    @Test
    public void roofLengthSurfacePitchedRoof() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 30);
        con.setRoof(roof);
        //Act
        int actuel = rs.roofLengthSurface();
        int expected = 780;
        //Assert
        assertEquals(expected, actuel);
    }

    @Test
    public void flatRoofCalcutatedLength() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofFlat(0,con.getConstructionLength(), con.getConstructionWidth());
        con.setRoof(roof);
        //Act
        int actuel = rs.flatRoofCalcutatedLength();
        int expected = 780;
        //Assert
        assertEquals(expected, actuel);
    }

    @Test
    public void pitchedRoofCalcutatedWidth() {
        //Arrange
        con.setConstructionLength(780);
        con.setConstructionWidth(360);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 30);
        con.setRoof(roof);
        //Act
        int actuel = rs.pitchedRoofCalcutatedWidth();
        int expected = 207;
        //Assert
        assertEquals(expected, actuel);
    }
}
