package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ConstructionSizeCalculatorTest {
    Construction construction = new Construction();
    ConstructionSizeCalculator constructionSizeCalculator = new ConstructionSizeCalculator();


    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(9100);
        construction.setCarportWidth(12300);
        Shed shed = new Shed((construction.getCarportWidth() / 2), 7600, "left");
        construction.setShed(shed);
<<<<<<< HEAD
        Roof pitchedRoof = new RoofFlat(construction.getConstructionHeight(), construction.getConstructionLength(),
                construction.getConstructionWidth(), 3);
=======
        Roof pitchedRoof = new RoofFlat(0, construction.getConstructionLength(),
                construction.getConstructionWidth(),3);
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        pitchedRoof.setDegree(3);
        construction.setRoof(pitchedRoof);
        construction.setConstructionWidth(500);
        construction.setConstructionLength(600);

    }


    @Test
    public void postRows() {
        int rows = ConstructionSizeCalculator.postRows(construction.getCarportWidth());
        assertEquals(4, rows);
    }


    @Test
    public void sidePostAmount() {
        int actual = ConstructionSizeCalculator.sidePostAmount(8500);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void postDistanceMax300() {
        int actual = ConstructionSizeCalculator.postDistanceMax3000(8600);
        int exp = 2833;
        assertEquals(exp, actual);

    }

    @Test
    public void shedFrontPostsAmount() {
        int actual = ConstructionSizeCalculator.shedFrontPostsAmount(1400);
        int expected = 2;
        assertEquals(expected, actual);
    }


    @Test
    public void postsHeights() {
        Integer[] heights = ConstructionSizeCalculator.postsHeights(2000, 3, 7200);

        int result = heights[3];
        assertEquals(2210, result);
        /*
        distance mellem stolper: 2366,7 og det svarer til 2366 som int
        højde stiger 70,98 mm dvs 70 som int
        1: 2000 (idex 0)
        2:2070 (idex 1)
        3:2140
         */
    }


    @Test
    public void raising() {
        double actual = ConstructionSizeCalculator.raising(8, 9750);
        double expected = 780;
        assertEquals(expected, actual, 0.01);

    }

    @Test
    public void possibleRems() {
        int actual = constructionSizeCalculator.possibleRems(construction);
        int expected = 540;
        assertEquals(expected, actual);
    }

    @Test
    public void remPieces() {
        // Hvis carportLength=500, constructionWidth=450, shedDepth=0
        // Hvis carportLength=750, constructionWidth=620, shedDepth=120
        // Hvis carportLength=750, constructionWidth=350, shedDepth=120
        // Nedenstående læser målene højere oppe fra
        int[] actual = constructionSizeCalculator.remPieces(construction, 0, 0, 0);
        int[] expected = {540, 540};
        //int[] expected = {300, 300, 300, 300, 300, 300, 480, 480, 480};
        //int[] expected = {300, 300, 300, 300, 480, 480};

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void remBoltAmount() {
        // Hvis carportWidth=620, shedDepth=0, carportLength=450
        // Hvis carportWidth=620, shedDepth=100, carportLength=450
        // Hvis carportWidth=400, shedDepth=100, carportLength=450
        int actual = constructionSizeCalculator.remBoltAmount(construction);
        //int expected = 18;
        //int expected = 28;
        int expected = 20;

        assertEquals(expected, actual);
    }

    @Test
    public void remSquaresAmount() {
        // Hvis carportWidth=620, shedDepth=0, carportLength=450
        // Hvis carportWidth=620, shedDepth=100, carportLength=450
        // Hvis carportWidth=400, shedDepth=100, carportLength=450
        int actual = constructionSizeCalculator.remSquaresAmount(construction);
        //int expected = 9;
        //int expected = 12;
        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void roofSpaerLength() {
        // Hvis constructionWidth=300
        // Hvis constructionWidth=500
        // Hvis constructionWidth=700
        int actual = constructionSizeCalculator.roofSpaerLength(construction);
        //int expected = 300;
        //int expected = 540;
        int expected = 720;
        assertEquals(expected, actual);
    }

    @Test
    public void roofSpaerAmount() {
        // Hvis constructionLength=400
        // Hvis constructionLength=540
        int actual = constructionSizeCalculator.roofSpaerAmount(construction);
        //int expected = 9;
        int expected = 12;
        assertEquals(expected, actual);

    }

    @Test
    public void universalBracketsRight() {
        // Hvis roofSpaerAmount=12 (constructionLength=540)
        int actual = constructionSizeCalculator.universalBracketsRight(construction);
        int expected = 12;
        assertEquals(expected, actual);
    }

    @Test
    public void perforatedBandRolls() {
        // Hvis carportLength=750, carportWidth=750
        // Hvis carportLength=450, carportWidth=450
        int actual = constructionSizeCalculator.perforatedBandRolls(construction);
        int expected = 2;
        //int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void bracketScrews() {
        // Hvis roofSpaerAmount=12 (constructionLength=540) = 128 skruer
        // Hvis roofSpaerAmount=16 (constructionLength=750) = 172 skruer
        // Hvis roofSpaerAmount=23 (constructionLength=1100) = 249 skruer
        int actual = constructionSizeCalculator.bracketScrews(construction);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void possibleSternSmall() {
        int actual = constructionSizeCalculator.possibleSternSmall(500, 5);
        int expected = 480;
        assertEquals(expected, actual);
    }

    @Test
    public void possibleSternDobbelt() {
        int actual = constructionSizeCalculator.possibleSternDobbelt(1100, 5);
        int expected = 600;
        assertEquals(expected, actual);
    }

    @Test
    public void underSternLengths() {
        // Hvis cunstructionLength=400, cunstructionWidth=500
        // Hvis cunstructionLength=600, cunstructionWidth=500
        // Hvis cunstructionLength=400, cunstructionWidth=700
        // Hvis cunstructionLength=700, cunstructionWidth=700
        int[] actual = constructionSizeCalculator.underSternPieces(construction);
        //int[] expected = {540, 540, 420, 420};
        //int[] expected = {540, 540, 360, 360, 360, 360};
        //int[] expected = {360, 360, 360, 360, 420, 420};
        int[] expected = {360, 360, 360, 360, 360, 360, 360, 360};

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void overSternLengths() {
        // Hvis cunstructionLength=600, cunstructionWidth=500
        int[] actual = constructionSizeCalculator.overSternPieces(construction);
        int[] expected = {540, 540, 360, 360, 360, 360};

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));

    }

    @Test
    public void carportMinHeight() {
        int minH = ConstructionSizeCalculator.carportMinHeight(2000, construction.getShed().getDepth(), 3);
        int exp = 2228;
        assertEquals(exp, minH);
    }
}