package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Magdalena
 */
public class OverlaySizeCalculatorTest {
    Construction construction = new Construction();


    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(7200);
        construction.setConstructionHeight(2000);
        construction.setCarportWidth(4200);
        Roof roof = new RoofFlat( 0, 7200+2900, 4200,3,false);
        construction.setRoof(roof);

        Shed shed = new Shed(4200/2,2900,"left");
        construction.setShed(shed);
        ArrayList<Wall> shedWalls= WallBuilder.addShedWalls(construction);
        shed.setWalls(shedWalls);
        String[] constructionWalls={"left","right"};
        ArrayList<Wall> carportWalls=WallBuilder.addConstructionWalls(construction, constructionWalls);
        construction.setWalls(carportWalls);
        construction.setShed(shed);
    }

    @Test
    public void spaerOnOneWall() {
        ArrayList<Wall> carportWalls=construction.getWalls();
        int index=-1;
        for (Wall wall: carportWalls) {
            if(wall.getSide().equals("carportright")&& wall.getMinHeight()>2000){
                index=carportWalls.indexOf(wall);
            }
        }


        Wall carportsWall=construction.getWalls().get(index);
        int expected = 9;
        int actual =OverlaySizeCalculator.spaerOnOneWall(carportsWall);
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
        for (Wall wall:construction.getWalls()
             ) {
            System.out.println(wall.getSide());
        }
        assertEquals(expected,actual);


    }

    @Test
    public void screwSpaer() {
        int expected=9*4;
        int actual= OverlaySizeCalculator.screwSpaer(9);

    }

    @Test
    public void fyrNumberOneWall() {
        ArrayList<Wall> carportWalls=construction.getWalls();
        int index=-1;
        for (Wall wall: carportWalls) {
            if(wall.getSide().equals("carportright")){
                index=carportWalls.indexOf(wall);
            }
        }

        Wall carportsRightWall=construction.getWalls().get(index);
        int expected=9;
        int actual = OverlaySizeCalculator.fyrNumberOnWall(carportsRightWall);

                /*
                 3 distances af 2366 mm hver
                 3 fyr per distance
                 */
        assertEquals(expected,actual);
    }



    @Test
    public void screwFyr() {
        int expected=9*9;
        int actual= OverlaySizeCalculator.screwFyr(9,9);
    }

    @Test
    public void fyrLengthsOneWall() {
        ArrayList<Wall> carportWalls=construction.getWalls();
        int index=-1;
        for (Wall wall: carportWalls) {
            if(wall.getSide().equals("right")&& wall.getMinHeight()>2000){
                index=carportWalls.indexOf(wall);
            }
        }

        Wall carportsRightWall=construction.getWalls().get(index);
        ArrayList<Integer> lengths= OverlaySizeCalculator.fyrLengthsOneWall(carportsRightWall);


    }

    @Test
    public void fyrLengths() {
    }

    @Test
    public void overlaySpending() {
    }

    @Test
    public void areal() {
    }

    @Test
    public void allWallsAreal() {
    }

    @Test
    public void countWoodLength() {
    }
}