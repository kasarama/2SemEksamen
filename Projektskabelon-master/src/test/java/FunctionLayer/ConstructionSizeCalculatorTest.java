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
        construction.setCarportLength(7500);
        construction.setCarportWidth(4000);
        Shed shed = new Shed((construction.getCarportWidth() / 2), 0, "left");
        construction.setShed(shed);

        Roof pitchedRoof = new RoofFlat(construction.getConstructionHeight(), construction.getConstructionLength(),
        construction.getConstructionWidth(), 3);
        pitchedRoof.setDegree(3);
        construction.setRoof(pitchedRoof);
        construction.setConstructionWidth(5000);
        construction.setConstructionLength(6000);

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
        // Hvis carportLength=5000, constructionWidth=4500, shedDepth=0
        // Hvis carportLength=750, constructionWidth=620, shedDepth=120
        // Hvis carportLength=750, constructionWidth=350, shedDepth=120
        // Nedenstående læser målene højere oppe fra
        int[] actual = constructionSizeCalculator.remPieces(construction);
        int[] expected = {540, 540};
        //int[] expected = {300, 300, 300, 300, 300, 300, 480, 480, 480};
        //int[] expected = {300, 300, 300, 300, 480, 480};

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void remBoltAmount() {
        // Hvis carportWidth=620, shedDepth=0, carportLength=450
        // Hvis carportWidth=620, shedDepth=100, carportLength=450
        // Hvis carportWidth=4000, shedDepth=1000, carportLength=4500
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
        // Hvis constructionWidth=7000
        int actual = constructionSizeCalculator.roofSpaerLength(construction);
        //int expected = 300;
        //int expected = 540;
        int expected = 720;
        assertEquals(expected, actual);
    }

    @Test
    public void roofSpaerAmount() {
        // Hvis constructionLength=400
        // Hvis constructionLength=5400
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
        // Hvis carportLength=7500, carportWidth=7500
        // Hvis carportLength=450, carportWidth=450
        int actual = constructionSizeCalculator.perforatedBandRolls(construction);
        int expected = 2;
        //int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void bracketScrews() {
        // Hvis roofSpaerAmount=12 (constructionLength=5400) = 128 skruer
        // Hvis roofSpaerAmount=16 (constructionLength=750) = 172 skruer
        // Hvis roofSpaerAmount=23 (constructionLength=1100) = 249 skruer
        int actual = constructionSizeCalculator.bracketScrews(construction);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void possibleSternSmall() {
        int actual = constructionSizeCalculator.possibleSternSmall(500, 5);
        int expected = 540;
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
        // Hvis cunstructionLength=7000, cunstructionWidth=7000
        int[] actual = constructionSizeCalculator.underSternPieces(construction);
        //int[] expected = {540, 540, 420, 420};
        //int[] expected = {540, 540, 360, 360, 360, 360};
        //int[] expected = {360, 360, 360, 360, 420, 420};
        int[] expected = {360, 360, 360, 360, 360, 360, 360, 360};

        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    @Test
    public void overSternLengths() {
        // Hvis cunstructionLength=6000, cunstructionWidth=5000
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