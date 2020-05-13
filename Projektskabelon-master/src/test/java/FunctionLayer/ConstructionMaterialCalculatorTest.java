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
        construction.setConstructionWidth();
        construction.setConstructionLength();
        construction.setCarportLength(500);

    }

// Denne test virker ikke selvom jeg får det rigtige resultat
    @Test
    public void woodMaterials() throws LoginSampleException {
        // Hvis carportLength=500, constructionWidth=450, shedDepth=0
        //int[] expected = {540, 540};
        ArrayList<Material> actual= constructionMaterialCalculator.woodMaterials(construction);
        ArrayList<Material> expected = new ArrayList<>();
            Material rem = new Material();
            rem.setName("45x195 MM. SPÆRTRÆ UBH.");
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
}
