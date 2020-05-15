package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RoofMaterialCalculatorTest {
    Construction construction = new Construction();
    RoofMaterialCalculator rmc;

    @Before
    public void setUp() throws Exception {
        //Arrange
        construction.setCarportLength();
        construction.getConstructionLength();
        Roof roof = new RoofFlat(0, construction.getConstructionLength(), construction.getConstructionWidth(), 3);
        construction.setRoof(roof);
    }

    @Test
    public void quantityOfT600ForRoofFlatRoof() {
        //Arrange
        construction.setCarportLength(12000);
        construction.setCarportWidth(3500);
        RoofSizing rs = new RoofSizing(construction);
        rmc = new RoofMaterialCalculator(construction);
        construction.getRoof().setHeight(rs.roofHeight(construction.getRoof().getIsPitched(), construction.getConstructionLength(), construction.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT600ForRoof(1090);
        int expected = 7;
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void quantityOfT600ForRoofFlatRoofThirdCoincidenceSquareWithoutT300() {
        //Arrange
        RoofMaterialCalculator rmc;
        construction.setCarportWidth(4500);
        construction.setCarportWidth(3500);
        RoofSizing rs = new RoofSizing(construction);
        rmc = new RoofMaterialCalculator(construction);
        construction.getRoof().setHeight(rs.roofHeight(construction.getRoof().getIsPitched(), construction.getConstructionLength(), construction.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT600ForRoof(1090);
        int expected = 4;
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void quantityOfT600ForRoofFlatRoofThirdCoincidenceSquareWithT300() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setCarportWidth(8000);
        con.setCarportLength(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc = new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT600ForRoof(1090);
        int expected = 4;
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void quantityOfT300ForRoofFlatRoofAreNone() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setCarportWidth(4500);
        con.setCarportLength(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc = new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT300ForRoof(1090);
        int expected = 0;
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void quantityOfT300ForRoofFlatRoofIsMoreThanZero() {
        //Arrange
        Construction con = new Construction();
        Roof roof;
        RoofMaterialCalculator rmc;
        con.setCarportWidth(8000);
        con.setCarportLength(3500);
        roof = new RoofFlat(0, con.getConstructionLength(), con.getConstructionWidth(), 3);
        con.setRoof(roof);
        RoofSizing rs = new RoofSizing(con);
        rmc = new RoofMaterialCalculator(con);
        con.getRoof().setHeight(rs.roofHeight(con.getRoof().getIsPitched(), con.getConstructionLength(), con.getConstructionWidth()));
        //Act
        int actual = rmc.quantityOfT300ForRoof(1090);
        int expected = 4;
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void flatRoofMaterialsInsert() throws LoginSampleException {
        RoofMaterialCalculator rf = new RoofMaterialCalculator(construction);
        ArrayList<Material> materials = rf.flatRoofMaterialsTrapezPlades("string");
        System.out.println("materials number: " + materials.size());
    }

    @Test
    public void quantityOfT600ForRoof() {
    }

    @Test
    public void quantityOfT300ForRoof() {
    }
}
