package FunctionLayer;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoofFlatTest {


    @Test
    public void getFlatRoofDegree() {
        //Arrange
        Construction con = new Construction();
        Roof flatRoof = new RoofFlat(20, 780, 380, 3); //tilfældige tal

        int excpeted = 2;
        //Act
        int actuel = flatRoof.getDegree();
        //Assert
        assertEquals(excpeted, actuel);
    }
}
