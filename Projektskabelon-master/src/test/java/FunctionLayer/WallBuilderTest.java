package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WallBuilderTest {
Construction construction = new Construction();
    String[] constructionWalls={"left","right"};
    @Before
    public void setUp() throws Exception {
        construction.setCarportLength(7200);
        construction.setConstructionHeight(2000);
        construction.setCarportWidth(4200);
        Roof roof = new RoofFlat( 0, 7200+2900, 4200,3,false);
        construction.setRoof(roof);
        Shed shed = new Shed(4200/2,2900,"left");
        construction.setShed(shed);

    }

    @Test
    public void addShedWalls() {
        ArrayList<Wall> shedWalls=WallBuilder.addShedWalls(construction);
        assertEquals("front",shedWalls.get(2).getSide());
        assertEquals(0,shedWalls.get(3).getRaising());

    }

    @Test
    public void addShedWallsNoShed() {
        construction.setShed(new Shed(0,0,""));
        ArrayList<Wall> shedWalls=WallBuilder.addShedWalls(construction);
        assertEquals(0,shedWalls.size());

    }
    @Test
    public void addCarportWalls() {
        ArrayList<Wall> carportWalls = WallBuilder.addCarportWalls(construction, constructionWalls);
        int leftWallLength=0;
        int rightWallLength=0;
        for (Wall wall: carportWalls) {
            if (wall.getSide().equals("left")){
                 leftWallLength=wall.getLength();
            }
        }
            for (Wall wall: carportWalls) {if (wall.getSide().equals("right")){
                rightWallLength=wall.getLength();
            }
        }
       assertEquals(construction.getCarportLength()+construction.getShed().getDepth()-100,rightWallLength);

        assertEquals(construction.getCarportLength(),leftWallLength);

    }

    @Test
    public void addCarportWallsNoShed() {
        construction.setShed(new Shed(0,0,""));
        ArrayList<Wall> carportWalls = WallBuilder.addCarportWalls(construction, constructionWalls);


    }
}