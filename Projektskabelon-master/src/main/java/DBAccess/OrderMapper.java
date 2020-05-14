package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.jar.JarOutputStream;

/**
 * @author Magdalena
 */
public class OrderMapper {


    public static int newOrder(Order order) throws LoginSampleException {
        String email = order.getEmail();
        int userID = UserMapper.getIDbyEmail(email);
        int orderID = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, date, status, cost, salePrice) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);//for at sikre os at vi fiske lige preæcis den id der er blevet genereret ved insertion
            ps.setInt(1, userID);
            ps.setLong(2, order.getTimestamp());
            ps.setString(3, order.getStatus());
            ps.setDouble(4, order.getCost());
            ps.setDouble(5, order.getSalePrice());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            orderID = ids.getInt(1);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }


        return orderID;


    }

    public static void saveNewRequest(Order order) throws LoginSampleException {
        //todo fix roof forms, so vi can use roof cover (Tagdækning)

        Construction construction = order.getConstruction();
        int overlayVariationID = 0;
        int roofVariationID = 0;
        if (construction.getColor() != null) {
            overlayVariationID = MaterialMapper.getVariationID(construction.getColor(), construction.getOverlay());
        }
        if (construction.getRoof().getColor() != null) {
            roofVariationID = MaterialMapper.getVariationID(construction.getRoof().getColor(), construction.getRoof().getCover());
        }

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
            String SQL = "INSERT INTO fogdb.orderdetails VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.setString(20, roof.getCover());
//
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


    public static ArrayList<Order> ReadAllOrdersByStatus(String status) throws LoginSampleException {
        ArrayList<Order> orders = new ArrayList<>();
        String danish = "status";
        switch (status) {
            case "newrequest":
                danish = "Ny forespørgelse";
                break;
            case "validated":
                danish = "Valideret";
                break;
            case "paid":
                danish = "Bestilt";
                break;
        }

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orderdetails LEFT JOIN orders ON orderdetails.orderID=orders.orderID " +
                    "WHERE status=? ORDER BY 'date' ASC";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
                int orderID = rs.getInt(1);
                int constructionHeight = rs.getInt(2);
                int carportWidth = rs.getInt(3);
                int carportLength = rs.getInt(4);
                int constructionLength = rs.getInt(5);
                int constructionWidth = rs.getInt(6);
                int shedDepth = rs.getInt(7);
                int shedWidth = rs.getInt(8);
                String shedSide = rs.getString(9);
                String overlay = rs.getString(10);
                int roofHeight = rs.getInt(11);
                int roofLength = rs.getInt(12);
                int roofWidth = rs.getInt(13);
                int roofDegree = rs.getInt(14);
                boolean ispitched = rs.getBoolean(15);
                int tilt = rs.getInt(16);
                String wallSides = rs.getString(17);
                String overlayColor = rs.getString(18);
                String roofColor = rs.getString(19);
                String roofCover = rs.getString(20);
                orderID = rs.getInt(21);
                int userID = rs.getInt(22);
                long date = rs.getLong(23);
                String statusDB = rs.getString(24);
                double cost = rs.getDouble(25);
                double salePrice = rs.getDouble(26);
                double transport = rs.getDouble(27);


                Shed shed = new Shed(shedWidth, shedDepth, shedSide);
                Roof roof;
                if (ispitched) {
                    roof = new RoofPitched(roofHeight, roofLength, roofWidth, roofDegree);
                } else {
                    roof = new RoofFlat(roofHeight, roofLength, roofWidth, tilt);
                }
                roof.setColor(roofColor);
                roof.setCover(roofCover);

                ArrayList<String> wallsides = new ArrayList<>();
                if (wallSides!=null) {
                    String[] tmp = wallSides.split(";");

                    for (int i = 0; i < tmp.length; i++) {
                        wallsides.add(tmp[i]);
                    }
                }
                Construction construction = new Construction(carportWidth, carportLength, constructionLength,
                        constructionWidth, shed, roof, constructionHeight, cost, salePrice,
                        overlay, wallsides, overlayColor);

                construction.setShed(shed);
                construction.setRoof(roof);

                String email = UserMapper.getEmailByID(userID);
                Order order = new Order(construction, orderID, userID, email, date, status, cost, salePrice);
                Date otherDate = new Date(date);
                order.setDate(otherDate);
                order.setTransport(transport);
                orders.add(order);

            }
            return orders;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException("Kunne ikke læse data om variationer af denne material: " + danish);
        }

    }

    public static void saveNewOffer(Order order) throws LoginSampleException {
        throw new LoginSampleException("Method for saving new offer in DB not awailable yet");
        //todo update order and orderdetails in DB
    }
}
