package FunctionLayer;

import DBAccess.MaterialMapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Magdalena
 */
public class OverlaySizeCalculatorTest {
    Construction construction = new Construction();
    Wall wall = new Wall();


    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(7200);
        construction.setConstructionHeight(2000);
        construction.setCarportWidth(4200);

        Roof roof = new RoofFlat( 0, 7200+2900, 4200,3);
        construction.setRoof(roof);

        Shed shed = new Shed(4200 / 2 + 50, 2900, "left");
        construction.setShed(shed);
        ArrayList<Wall> shedWalls = WallBuilder.addShedWalls(construction);
        shed.setWalls(shedWalls);
        String[] constructionWalls = {"left", "right"};
        ArrayList<Wall> carportWalls = WallBuilder.addConstructionWalls(construction, constructionWalls);
        construction.setWalls(carportWalls);
        construction.setShed(shed);

        wall.setRaising(3);
        wall.setSide("left");
        wall.setMinHeight(2500);
        wall.setLength(5800);
    }

    @Test
    public void spaerOnOneWall() {
        ArrayList<Wall> carportWalls = construction.getWalls();
        int index = -1;
        for (Wall wall : carportWalls) {
            if (wall.getSide().equals("carportright")) {
                index = carportWalls.indexOf(wall);
            }
        }


        Wall carportsWall = construction.getWalls().get(index);
        int expected = 9;
        int actual = OverlaySizeCalculator.spaerOnOneWall(carportsWall);
                /*
                3 distances af 2366 mm hver
                raising=70,98/distance
                1 stolp: 2070
                2 stolp: 2141
                3 stolp: 2212
                1+2+
                1+2+
                1+2=9
                 */
        for (Wall wall : construction.getWalls()
        ) {
            System.out.println(wall.getSide());
        }
        assertEquals(expected, actual);


    }

    @Test
    public void spaerLengthOneWall() {
        int result = OverlaySizeCalculator.spaerLengthOneWall(wall);
        assertEquals(2850,result);
    }


    @Test
    public void screwSpaer() {
        int expected = 9 * 4;
        int actual = OverlaySizeCalculator.screwSpaer(9);
        assertEquals(expected,actual);

    }


    @Test
    public void fyrQuantityOnWall() {
        ArrayList<Wall> carportWalls = construction.getWalls();
        int index = -1;
        for (Wall wall : carportWalls) {
            if (wall.getSide().equals("carportright")) {
                index = carportWalls.indexOf(wall);
            }
        }

        Wall carportsRightWall = construction.getWalls().get(index);
        int expected = 9;
        int actual = OverlaySizeCalculator.fyrQuantityOnWall(carportsRightWall);

                /*
                 3 distances af 2366 mm hver
                 3 fyr per distance
                 */
        assertEquals(expected, actual);
    }


    @Test
    public void screwFyr() {
        int expected = 9 * 9;
        int actual = OverlaySizeCalculator.screwFyr(9, 9);
        assertEquals(expected,actual);
    }

    @Test
    public void fyrLengthsOneWall() {

        ArrayList<Integer> lengths = OverlaySizeCalculator.fyrLengthsOneWall(wall);
        /*
        distance =  518
        fyr + posts = 11
        posts: 3
        raising=17

         */
        int result = lengths.get(0);
        int result2 = lengths.get(7);
        int expected1=wall.getMinHeight()+17;
        int expected2=wall.getMinHeight()+17*9;
        assertEquals(8,lengths.size());
        assertEquals(expected1,result);
        assertEquals(expected2,result2);
    }


    @Test
    public void oneWallArea() {
        ArrayList<Wall> carportWalls = construction.getWalls();
        int index = -1;
        for (Wall wall : carportWalls) {
            System.out.println(wall.getSide());
            if (wall.getSide().equals("likeShedright")) {
                index = carportWalls.indexOf(wall);
            }
        }
        Wall likeShedright = construction.getWalls().get(index);

        double actual = OverlaySizeCalculator.oneWallArea(likeShedright);
        double expected = 5.92615;

        assertEquals(expected, actual, 0.01);
    }


    @Test
    public void allWallsAreal() {

        double totalSurface = OverlaySizeCalculator.allWallsArea(construction);
        double expected = (3 * ((2000 + 2087) / 2 * 2900) + 2 * ((2087 + 2303) / 2 * 7200) + (2000 * 2150) + (2087 * 2150));
        expected = expected / 1000 / 1000;
        assertEquals(expected, totalSurface, 0.01);
    }

    @Test
    public void overlaySpending() {
        int result1;
        int result2;
        double spending = 3.85;

        String materialName1 = "HARDIEPLANK 180X3600X8MM";
        String materialName2 = "Some other name";
        double area = 100.1;



        double needed1 = 0;
        if (materialName1.equals("HARDIEPLANK 180X3600X8MM")) {
            needed1 = spending * area; //spending : how many pieces pr squwe meter
        } else {
            needed1 = spending * area * 3600 / 1000;
        }

        needed1 = needed1 + 0.05 * needed1; //5 % extra material for cuts

        if (((needed1 * 10) % 10) == 0) {
            result1 = (int) needed1;
        } else {
            result1 = (int) needed1 + 1;
        }

        double needed2 = 0;
        if (materialName1.equals("HARDIEPLANK 180X3600X8MM")) {
            needed2 = spending * area; //spending : how many pieces pr square meter
        } else {
            needed2 = spending * area / 3600 / 1000;
        }

        needed2 = needed2 + 0.05 * needed2; //5 % extra material for cuts

        if (((needed2 * 10) % 10) == 0) {
            result2 = (int) needed2;
        } else {
            result2 = (int) needed2 + 1;
        }


        int exepted1 = 405;
        int exepted2 = 108;
        assertEquals(exepted1,result1);


    }

    @Test
    public void countWoodLength() {
    }

    @Test
    public void overlayScrewOneWall() {
        Wall wall = new Wall();
        wall.setLength(5200);
        wall.setMinHeight(2000);
        wall.setSide("right");
        wall.setRaising(3);


        ArrayList<Integer> fyrLengthsOneWall = new ArrayList<>();
        /*
        counts number of all vertical tree elements on one wall
        counts distance between them and raising pr that distance,
        calculates and adds height of every element
         */
        int distance = wall.getLength() - 100; // 100 mm for one post
        int fyrPlusPost = 0;
        if (distance % 600== 0) {
            fyrPlusPost = (distance / 600) + 1;
        } else {
            fyrPlusPost = (distance - distance % 600) / 600 + 2;
        }
        int distanceBetweenFyr = distance / (fyrPlusPost - 1);
        double raising = ConstructionSizeCalculator.raising(wall.getRaising(), distanceBetweenFyr);
        for (int i = 0; i < fyrPlusPost; i++) {

            int fyrLength = (int) (wall.getMinHeight() + raising * i);
            fyrLengthsOneWall.add(fyrLength);
        }
        int width = 128;

        int quantity = 0;
        for (Integer length : fyrLengthsOneWall) {
            if(length%width==0){
                quantity = quantity + length / width;
            } else {
                quantity = quantity + ((length - (length % width)  ) +1) / width;
            }
        }
        assertEquals(((10*2000)+(10*16))/128,quantity);

    }

    @Test
    public void overDoorSpearQuantity() {
        int result = OverlaySizeCalculator.overDoorSpearQuantity(2133);
        int expected = 3;
        assertEquals(expected,result);
    }
}