package PresentationLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OverlayTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public  void  nullStrings (){

        String a=null;
        String b=null;
        String c=null;
        String d= "A";
        ArrayList<String> strings = new ArrayList<>();
        strings.add(b);
        strings.add(c);
        strings.add(d);
        strings.add(a);
        assertEquals(1,strings.size());
    }
}