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
<<<<<<< HEAD
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
=======
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT600ForRoof();
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
<<<<<<< HEAD
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
=======
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT600ForRoof();
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
<<<<<<< HEAD
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
=======
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT600ForRoof();
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
<<<<<<< HEAD
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
=======
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT300ForRoof();
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
<<<<<<< HEAD
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
=======
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(),3);
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT300ForRoof();
        int expected = 4;
        //Assert
        assertEquals(expected,actual);
    }

    /*//For tag med rejsning
    @Test
    public void quantityOfT600ForRoofPitchedRoofTest() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(12000);
        con.setConstructionWidth(3000);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 30);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT600ForRoof();
        int expected = 8;
        //Assert
        assertEquals(expected,actual);
    }


    @Test
    public void quantityOfT600ForRoofPitchedRoofWithT300() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(8000);
        con.setConstructionWidth(7000);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 30);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT600ForRoof();
        int expected = 2;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void quantityOfT300ForRoofPitchedRoof() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setConstructionLength(8000);
        con.setConstructionWidth(7000);
        roof = new RoofPitched(0, con.getConstructionLength(), con.getConstructionWidth(), 40);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc= new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched()));
        //Act
        int actual = rmc.quantityOfT300ForRoof();
        int expected = 0;
        //Assert
        assertEquals(expected,actual);
    }*/

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
