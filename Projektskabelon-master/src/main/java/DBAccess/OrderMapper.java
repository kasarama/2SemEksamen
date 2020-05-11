package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class OrderMapper {


    public static int newOrder(Order order) throws LoginSampleException {
        String email = order.getEmail();
        int userID = UserMapper.getIDbyEmail(email);
        int orderID = 0;
        System.out.println("OrderMapper newOrder()");
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, date, status, cost, salePrice) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);
            ps.setLong(2, order.getTimestamp());
            ps.setString(3, order.getStatus());
            ps.setDouble(4, order.getCost());
            ps.setDouble(5, order.getSalePrice());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            orderID = ids.getInt(1);
            System.out.println("Order id to return: " + orderID);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }


        return orderID;


    }

    public static void saveNewRequest(Order order) throws LoginSampleException {
        System.out.println("OrderMapper.saveNewRequest()");
        Construction construction = order.getConstruction();
        Shed shed = construction.getShed();
        Roof roof = construction.getRoof();
        ArrayList<String> wallSidesList = construction.getWallSides();
        String wallSides = null;
        if (wallSidesList.size() > 1) {
            wallSides = wallSidesList.get(0);
            for (int i = 1; i < wallSidesList.size(); i++) {
                wallSides = wallSides + ";" + wallSidesList.get(i);
            }
        } else if (wallSidesList.size() == 1) {
            wallSides = wallSidesList.get(0);
        }


        int orderID = newOrder(order);
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogdb.orderdetails VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.setString(17, wallSides);
            ps.setString(18, construction.getColor());
            ps.setString(19, roof.getColor());
            ps.executeUpdate();
        } catch (
                SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException("Problem while saving in database");
        } catch (
                ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
