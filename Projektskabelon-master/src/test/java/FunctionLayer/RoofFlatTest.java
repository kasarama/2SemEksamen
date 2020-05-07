package FunctionLayer;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoofFlatTest {


    @Test
    public void getFlatRoofDegree() {
        //Arrange
        Construction con = new Construction();
<<<<<<< HEAD
        Roof flatRoof = new RoofFlat(20, 780, 380, 3); //tilfældige tal
=======
        Roof flatRoof = new RoofFlat(20, 780, 380,3); //tilfældige tal
>>>>>>> b2a0bbd49392224361ee1b755fddebf94a0d0409
        int excpeted = 2;
        //Act
        int actuel = flatRoof.getDegree();
        //Assert
        assertEquals(excpeted, actuel);
    }
}
