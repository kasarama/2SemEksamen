package DBAccess;

import FunctionLayer.Construction;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Roof;
import FunctionLayer.Shed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstructionMapper {


    public static int newOrder(Construction construction, String email) throws LoginSampleException {
        int userID = UserMapper.getIDbyEmail(email);
        int orderID = 0;

        return orderID;


    }

    public static void saveNewRequest(Construction construction, String email) throws LoginSampleException {

        Shed shed = construction.getShed();
        Roof roof = construction.getRoof();
        String wallSides="";
        for (String side : construction.getWallSides()) {
            wallSides =wallSides +";"+side;
        }

        int orderID=newOrder(construction, email);
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogdb.orderdetails VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ps.setInt(2, construction.getConstructionHeight());
            ps.setInt(3, construction.getCarportLength());
            ps.setInt(4, construction.getCarportWidth());
            ps.setInt(5, construction.getConstructionLength());
            ps.setInt(6, construction.getConstructionWidth());
            ps.setInt(7, shed.getDepth());
            ps.setInt(8, shed.getWidth());
            ps.setString(9, shed.getSide());
            ps.setString(10, construction.getOverlay());
            ps.setInt(11, roof.getHeight());
            ps.setInt(12, roof.getLength());
            ps.setInt(13, roof.getWidth());
            ps.setInt(14, roof.getDegree());
            ps.setBoolean(15, roof.getIsPitched());
            ps.setInt(16, roof.getTilt());
            ps.setString(17,wallSides);
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
