package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import java.sql.*;

public class MaterialMapper {

    // Skal have fat i et materiale ud fra note

    // Vi vil vide hvor meget materiale der skal bruges


// @author Mia
    public static Material getMaterialBySize(int size) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT materialID, size FROM fogdb.sizes "
                    + "WHERE size=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, size);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int materialID = rs.getInt("materialID");
                material = new Material(materialID, size);
            }else {
                System.out.println("ResultSet.next()=false");
                return null;  }//todo handle null object there where method is being used;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return material;
    }
    public static Material getMaterialByID(int id) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name FROM fogdb.materials "
                    + "WHERE materialID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                material = new Material(id, name, null);
            }else {
                System.out.println("ResultSet.next()=false");
                return null;  }//todo handle null object there where method is being used;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return material;
    }
    public static String getUnitByName (String name) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT unit FROM fogdb.materials WHERE name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String unit = rs.getString("unit");
                material = new Material(0, name, unit);
                material.setUnit(unit);
                return material.getUnit();
            } else {
                material.setUnit(null);
                return material.getUnit();
            }
        }catch (SQLException sql){
            material.setUnit(null);
            return material.getUnit();
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static int getWidthByID (int id, String name) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT width FROM fogdb.materials WHERE materialID=? and name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int width = rs.getInt("width");
                material = new Material(id, name, width);
                material.setWidth(width);
                return material.getWidth();
            } else {
                material.setUnit(null);
                return material.getWidth();
            }
        }catch (SQLException sql){
            material.setUnit(null);
            return material.getWidth();
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int getThicknessByID (int id) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT thickness FROM fogdb.materials WHERE materialID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int thickness = rs.getInt("thickness");
                material = new Material(id, thickness);
                material.setThickness(thickness);
                return material.getThickness();
            } else {
                material.setUnit(null);
                return material.getThickness();
            }
        }catch (SQLException sql){
            material.setUnit(null);
            return material.getThickness();
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }







// This class Connects to DB and gets the "Roof material" data from it.

    //1. create a method that returns a list of ROOF Materials -  Material = Class from function Layer
    public static List<Material> getAllPitchedRoofMaterials() throws LoginSampleException {
        List<Material> materialList = null;

        //try-catch block in case an error occurs.
        try {
            //2. start the connection by calling ".connection()" method from the "Connector" class
            Connection con = Connector.connection();
            //3. create an SQL statement - select only 'tag' from the 'material' table
            String SQL = "SELECT * FROM materials WHERE category = 'TagPitched'";
            //4. insert the SQL statement into the ".preparedStatement()" method - it sends the SQL statement to the DB
            PreparedStatement ps = con.prepareStatement(SQL);
            //5. call the ".executeQuery()" to execute the SQL statement and return the result (stored in ResultSet).
            ResultSet rs = ps.executeQuery();//works with getters/setters from "Info" class

            //6. while there is a next 'rs' (result i.e element) - do the following code
            while (rs.next()) {

                //if the 'materialList' is empty
                if (materialList == null) {
                    materialList = new ArrayList<>(); //design choice - to easily switch to ArrayList implementation
                }

                //get the data rows:
                int materialID = rs.getInt("materialID");
                String name = rs.getString("name");
                int size = rs.getInt("size");
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");

                //create a new material obj of 'Material' class and pass the gotten data in it (materialID, name, size etc)
                Material material = new Material(materialID, name, size, unit, keyword, category);// data gets stored in 'material'
                //add the gotten 'info' data to the 'InfoList'
                materialList.add(material);
            }
        }
        //catch the SQLException
        catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage()); //get the error message
        }
        // return the gotten 'material' data from the DB
        return materialList;
    }
    public static List<Material> getAllFlatRoofMaterials() throws LoginSampleException {
        List<Material> materialList = null;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM materials WHERE category = 'TagFladt'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (materialList == null) {
                    materialList = new ArrayList<>();
                }
                int materialID = rs.getInt("materialID");
                String name = rs.getString("name");
                int size = rs.getInt("size");
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");

                Material material = new Material(materialID, name, size, unit, keyword, category);
                materialList.add(material);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return materialList;
    }

    // This class Connects to DB and gets the "Overlay material" data from it.

    //Magdalena
    public static List<Material> getAllOverlays() throws LoginSampleException {
        List<Material> materialList=new ArrayList<>();
        try
        {
//todo edit the method so it uses parameters and question marks
            Connection con = Connector.connection();
            String SQL = "SELECT materialID, name, picture FROM materials WHERE category='overlay' and keyword='overlay'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String picture = rs.getString("picture");
                int materialID = rs.getInt("materialID");

                Material material = new Material();
                material.setName(name);
                material.setPicture(picture);
                material.setId(materialID);
                materialList.add(material);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return materialList;
    }

    //Magdalena
    public static void addMatDB(Material material) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materials (name,size,unit,keyword,category,price,picture) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, material.getName());
            ps.setInt(2, material.getSize());
            ps.setString(3, material.getUnit());
            ps.setString(4, material.getKeyword());
            ps.setString(5, material.getCategory());
            ps.setDouble(6, material.getPrice());
            ps.setString(7, material.getPicture());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException("Problem while saving in database");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }

    }

    //Magdalena
    public static List<Material> getAllOverlayMaterials() throws LoginSampleException {
        //todo edit the method so it uses parameters and question marks
        List<Material> materialList=new ArrayList<>();
        try
        {
            Connection con = Connector.connection();
            String SQL = "SELECT materialID, name, size, unit, price, picture FROM materials WHERE category='overlay'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {

                int materialID = rs.getInt("materialID");
                String name = rs.getString("name");
                String picture = rs.getString("picture");
                int size = rs.getInt("size");
                String unit = rs.getString("unit");
                double price = rs.getDouble("price");


                Material material = new Material();
                material.setId(materialID);
                material.setName(name);
                material.setSize(size);
                material.setUnit(unit);
                material.setPrice(price);
                material.setPicture(picture);
                materialList.add(material);
            }
        }
        catch(ClassNotFoundException | SQLException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }
        return materialList;
    }

    //Magdalena
    public static double spending (String name) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT spending FROM fogdb.materials WHERE name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double spending = rs.getDouble("spending");
                return spending;
            } else {
                return 0;
            }
        }catch (SQLException sql){
            return 0;
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}

