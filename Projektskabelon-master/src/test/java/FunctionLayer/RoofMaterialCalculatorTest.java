package FunctionLayer;

import PresentationLayer.FlatRoof;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class RoofMaterialCalculatorTest {

 //For fladt tag
    @Test
    public void quantityOfT600ForRoofFlatRoof() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(12000);
        con.setConstructionWidth(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT600ForRoof(1090);
        int expected = 7;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void quantityOfT600ForRoofFlatRoofThirdCoincidenceSquareWithoutT300() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(4500);
        con.setConstructionWidth(3500);

        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);

        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT600ForRoof(1090);
        int expected = 4;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void quantityOfT600ForRoofFlatRoofThirdCoincidenceSquareWithT300() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(8000);
        con.setConstructionWidth(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT600ForRoof(1090);
        int expected = 4;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void quantityOfT300ForRoofFlatRoofAreNone() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(4500);
        con.setConstructionWidth(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT300ForRoof(1090);
        int expected = 0;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void quantityOfT300ForRoofFlatRoofIsMoreThanZero() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(8000);
        con.setConstructionWidth(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT300ForRoof(1090);
        int expected = 4;
        //Assert
        assertEquals(expected,actual);
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
