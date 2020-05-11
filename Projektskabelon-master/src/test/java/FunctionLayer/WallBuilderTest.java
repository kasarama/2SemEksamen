package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Magdalena
 */
public class WallBuilderTest {
    Construction construction = new Construction();
    String[] constructionWalls = {"left", "right"};
    ArrayList<String> sideNames = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(7200);
        construction.setConstructionHeight(2000);
        construction.setCarportWidth(4200);
        Roof roof = new RoofFlat(0, 7200 + 2900, 4200, 3);
        construction.setRoof(roof);
        Shed shed = new Shed(4200 / 2, 2900, "left");
        construction.setShed(shed);
        sideNames.add("left");
        sideNames.add("right");
        sideNames.add("back");

    }

    @Test
    public void addShedWalls() {
        ArrayList<Wall> shedWalls = WallBuilder.addShedWalls(construction);
        assertEquals("front", shedWalls.get(2).getSide());
        assertEquals(0, shedWalls.get(3).getRaising());
        assertEquals(4,shedWalls.size());

    }

    @Test
    public void addShedWallsNoShed() {
        construction.setShed(new Shed(0, 0, ""));
        ArrayList<Wall> shedWalls = WallBuilder.addShedWalls(construction);
        assertEquals(0, shedWalls.size());

    }


    @Test
    public void QuantityOfcreateCarportWalls(){
        sideNames = new ArrayList<>();
        ArrayList<Wall> carportWalls = WallBuilder.createCarportWalls(construction, sideNames);
        System.out.println(carportWalls.size());


    }
    @Test
    public void createCarportWalls() {
        ArrayList<Wall> carportWalls = WallBuilder.createCarportWalls(construction, sideNames);
        int leftWallLength = 0;
        int rightWallLength = 0;
        for (Wall wall : carportWalls) {
            if (wall.getSide().equals("carportleft")) {
                leftWallLength = wall.getLength();
            }
        }
        for (Wall wall : carportWalls) {
            if (wall.getSide().equals("carportright")) {
                rightWallLength = wall.getLength();
            }
        }

        int likeShed = 0;
        for (Wall wall : carportWalls) {
            if (wall.getSide().equals("likeShedright")) {
                likeShed = wall.getLength();
            }
        }

        int back = 0;
        for (Wall wall : carportWalls) {
            if (wall.getSide().equals("carportback")) {
                back = wall.getLength();
            }
        }

            assertEquals(construction.getCarportLength(), rightWallLength);
            assertEquals(construction.getCarportLength(), leftWallLength);
            assertEquals(construction.getShedDepth(), likeShed);
            assertEquals(4,carportWalls.size());
            assertEquals(construction.getShed().getWidth(), back);


        }
    }