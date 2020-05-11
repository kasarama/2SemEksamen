package DBAccess;

import FunctionLayer.Construction;
import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstructionMapper {


    public  static void newOrder(Construction construction, String email) throws LoginSampleException {
        int UserId = UserMapper.getIDbyEmail(email);





    }
    public static void saveNewRequest(Construction construction) throws LoginSampleException {
      //  throw new LoginSampleException("Method to save a whole construction is not ready jet");

try{
        Connection con = Connector.connection();
        String SQL = "(orderID, constructionHeight, carportWidth, carportLength, constructionLength, constructionWidth, shedDepth, shedSide, constructionscol, overlay, roofHeight, roofLength, roofWidth, roofDegree, ispitched, tilt) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement ps = con.prepareStatement(SQL);

        ps.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
        throw new LoginSampleException("Problem while saving in database");
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
        throw new LoginSampleException(ex.getMessage());
    }
    }
}
