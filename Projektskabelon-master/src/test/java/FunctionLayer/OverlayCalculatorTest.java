package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static FunctionLayer.OverlayCalculator.shedSidePostsAmount;
import static org.junit.Assert.*;

public class OverlayCalculatorTest {
int numberOfPost;
Carport carport = new Carport();


    @Before
    public void setUp() throws Exception {
        carport.setLength(910);
        carport.setWidth(1230);
        Shed shed = new Shed((carport.getWidth()/2),460,"left");
        carport.setShed(shed);

    }

    @Test
    public void carportSidePosts() {
        int numberOfPost;
        if(carport.getLength()%300==0){
            numberOfPost=carport.getLength()/300+1;
        } else {
            numberOfPost=carport.getLength()/300+2;
        }
        assertEquals(5,numberOfPost);
    }

    @Test
    public void carportPostDistance() {

    }

    @Test
    public void postRows() {
        int rows;
        if(carport.getWidth()%600==0){
            rows=carport.getLength()/600+1;
        } else {
            rows=(carport.getWidth() - carport.getWidth()%600)/600 +2;
        }
        assertEquals(4,rows);
    }

    @Test
    public void shedSidePostDistance() {
        int result= OverlayCalculator.shedSidePostDistance(carport);
        int expected=225;
        assertEquals(expected,result);


    }

    @Test
    public void shedSidePostsAmount() {
        assertEquals(3,OverlayCalculator.shedSidePostsAmount(this.carport));
    }

    @Test
    public void countWoodLength() {
    int result = OverlayCalculator.countWoodLength(225);
    int expected = 240;
    assertEquals(expected, result);
    }

    @Test
    public void framingH() {
        ArrayList<Material> materials = OverlayCalculator.framingH(carport);
        int result = materials.size();
        int expected= 21;
        assertEquals(expected,result);


    }

    @Test
    public void shedBackPostsAmount() {
        int res =OverlayCalculator.shedBackPostsAmount(carport);
        assertEquals(4,res);
    }
}