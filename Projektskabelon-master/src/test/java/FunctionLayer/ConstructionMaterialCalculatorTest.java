package FunctionLayer;

import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConstructionMaterialCalculatorTest {
    Construction construction = new Construction();
    ConstructionMaterialCalculator constructionMaterialCalculator = new ConstructionMaterialCalculator();

    @Before
    public void setUp() throws Exception {
        Shed shed = new Shed((construction.getCarportWidth()/2),0,"left");
        construction.setShed(shed);
        construction.setCarportWidth(4500);
        construction.setCarportLength(5000);
        construction.setConstructionHeight(2000);
        construction.setCarportLength();
        construction.setCarportWidth();
        //construction.setCarportLength(500);
        Roof roof = new RoofFlat(0, construction.getConstructionLength(),construction.getConstructionWidth(), 3);
        construction.setRoof(roof);
        RoofSizing roofSizing = new RoofSizing(construction);
        int roofFlatHeight = roofSizing.roofHeight(false,construction.getConstructionLength(), construction.getConstructionWidth());

        construction.getRoof().setHeight(roofFlatHeight);
    }

// Denne test virker ikke selvom jeg får det rigtige resultat
    @Test
    public void woodMaterials() throws LoginSampleException {
        // Hvis carportLength=500, constructionWidth=450, shedDepth=0
        //int[] expected = {540, 540};
        ArrayList<Material> actual= constructionMaterialCalculator.woodMaterials(construction);
        ArrayList<Material> expected = new ArrayList<>();
            Material rem = new Material();
            rem.setName("SPÆRTRÆ UBEHANDLET");
            rem.setComment("Rem");
            rem.setSize(540);
            expected.add(rem);
            expected.add(rem);
        assertEquals(expected,actual);
    }

    @Test
    public void metalMaterials() throws LoginSampleException {
        ArrayList<Material> actual= constructionMaterialCalculator.metalMaterials(construction);
        ArrayList<Material> expected = new ArrayList<>();
        assertEquals(expected,actual);
    }

    @Test
    public void postsQuatity() throws LoginSampleException {
        //Arrange
        Material post = new Material();
        post.setName("TRYKIMPRENERET STOLPE");
        post.setAmount(9);
        ArrayList<Material> expected = new ArrayList<>();
        expected.add(post);
        //Act
        ArrayList<Material> actual= constructionMaterialCalculator.postsQuatity(construction);
        //Assert
        assertEquals(expected,actual);
    }
}
