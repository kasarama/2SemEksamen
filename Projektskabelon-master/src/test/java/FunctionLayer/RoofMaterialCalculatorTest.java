package FunctionLayer;

import PresentationLayer.FlatRoof;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RoofMaterialCalculatorTest {
Construction construction = new Construction();
/*
>>>>>>> lifeOfOrder
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
<<<<<<< HEAD
=======
*/
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

    @Before
    public void setUp() throws Exception {
        //Roof roof =new RoofFlat()construction.setRoof(roof);
    }

    @Test
    public void flatRoofMaterialsInsert() throws LoginSampleException {
        RoofMaterialCalculator rf =new RoofMaterialCalculator(construction);
        ArrayList<Material> materials =rf.flatRoofMaterialsInsert("string");
        System.out.println("materials number: "+materials.size());
    }
}
