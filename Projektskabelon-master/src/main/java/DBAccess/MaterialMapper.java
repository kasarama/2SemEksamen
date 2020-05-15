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

    //.......................................Mia's Metoder.......................................................//
    public static Material getMaterialBySizeName(int length, String name) throws LoginSampleException {
        Material material; //= new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogdb.materials LEFT JOIN fogdb.variations " +
                    "ON variations.materialID = materials.materialID WHERE materials.name=? and variations.length=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setInt(2, length);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("materialID");
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");
                material = new Material(id, name, length, unit, keyword, category);
                return material;
            } else {
                return null;
            }//todo handle null object there where method is being used;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
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
            } else {
                return null;
            }//todo handle null object there where method is being used;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return material;
    }

    public static String getUnitByName(String name) throws LoginSampleException {
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
        } catch (SQLException sql) {
            material.setUnit(null);
            return material.getUnit();
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int getWidthByID(int id, String name) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT width FROM fogdb.materials WHERE materialID=? and name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int width = rs.getInt("width");
                material = new Material(id, name, width);
                material.setWidth(width);
                //return material.getWidth();
            }
        } catch (SQLException sql) {
            System.out.println("Der skete en fejl 1");
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return material.getWidth();
    }

    public static int getThicknessByID(int id) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT thickness FROM fogdb.materials WHERE materialID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thickness = rs.getInt("thickness");
                material = new Material(id, thickness);
                material.setThickness(thickness);
                //return material.getThickness();
            }
        } catch (SQLException sql) {
            System.out.println("Der skete en fejl 2");
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return material.getThickness();
    }

    public static double getPrices(int id) throws LoginSampleException {
        Material material = new Material();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT price FROM fogdb.materials WHERE materialID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double price = rs.getDouble("price");
                material = new Material();
                material.setPrice(price);
                //return material.getPrice();
            }
        } catch (SQLException sql) {
            System.out.println("Der skete en fejl 3");
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return material.getPrice();
    }

    //.......................................Mia's Metoder SLUT.................................................//


// This class Connects to DB and gets the "Roof material" data from it.

    /*//1. create a method that returns a list of ROOF Materials -  Material = Class from function Layer
    public static List<Material> getAllPitchedRoofMaterials() throws LoginSampleException {
        List<Material> materialList = null;

        //try-catch block in case an error occurs.
        try {
            //2. start the connection by calling ".connection()" method from the "Connector" class
            Connection con = Connector.connection();
            //3. create an SQL statement - select only 'tag' from the 'material' table
            String SQL = "SELECT * FROM fogdb.materials WHERE category = 'FladtTag'";
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
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");

                //create a new material obj of 'Material' class and pass the gotten data in it (materialID, name, size etc)
                Material material = new Material(materialID, name, 0, unit, keyword, category);// data gets stored in 'material'
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
*/
    //Cath version
    public static List<Material> getAllPitchedRoofMaterials() throws LoginSampleException {
        List<Material> materialList = null;

        //try-catch block in case an error occurs.
        try {
            //2. start the connection by calling ".connection()" method from the "Connector" class
            Connection con = Connector.connection();
            //3. create an SQL statement - select everything from only 'RejsningTag' from the 'material' table
            String SQL = "SELECT * FROM fogdb.materials LEFT JOIN fogdb.variations " +
                    "ON materials.materialID=variations.materialID WHERE materials.category=?;";
            //4. insert the SQL statement into the ".preparedStatement()" method - it sends the SQL statement to the DB
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "RejsningTag");
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
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");
                int length = rs.getInt("length");
                String color = rs.getString("color");

                //create a new material obj of 'Material' class and pass the gotten data in it (materialID, name, size etc)
                Material material = new Material(materialID, name, length, unit, keyword, category);// data gets stored in 'material'
                material.setColor(color);
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
///////// version slut

    public static List<Material> getAllRoofMaterialsByCategory(String roofType) throws LoginSampleException {
        List<Material> materialList = null;

        //try-catch block in case an error occurs.
        try {
            //2. start the connection by calling ".connection()" method from the "Connector" class
            Connection con = Connector.connection();
            //3. create an SQL statement - select everything from only 'RejsningTag' from the 'material' table
            String SQL = "SELECT materials.name FROM fogdb.materials LEFT JOIN fogdb.variations " +
                    "ON materials.materialID=variations.materialID WHERE materials.category=?;";
            //4. insert the SQL statement into the ".preparedStatement()" method - it sends the SQL statement to the DB
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "\'" + roofType + "\'");
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
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");
                int length = rs.getInt("length");

                //create a new material obj of 'Material' class and pass the gotten data in it (materialID, name, size etc)
                Material material = new Material(materialID, name, length, unit, keyword, category);// data gets stored in 'material'
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
            String SQL = "SELECT * FROM materials WHERE keyword = 'FladtTag'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (materialList == null) {
                    materialList = new ArrayList<>();
                }
                int materialID = rs.getInt("materialID");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                String keyword = rs.getString("keyword");
                String category = rs.getString("category");

                Material material = new Material(materialID, name, 0, unit, keyword, category);
                materialList.add(material);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return materialList;
    }

    // This class Connects to DB and gets the "Overlay material" data from it.


    //.......................................MAGDA'S Methods.............................................//


    /**
     * @return List<Material>
     * @throws LoginSampleException The purpose of this method is to get all position from database from materials table, where
     *                              category='overlayMaterial' end return them on list of Material
     * @author Magdalena
     */
    public static List<Material> getAllOverlays() throws LoginSampleException {
        List<Material> materialList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name, picture, price, color FROM materials LEFT JOIN variations " +
                    "ON materials.materialID=variations.materialID WHERE category='overlayMaterial'";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String picture = rs.getString("picture");
                double price = rs.getDouble("price");
                String color = rs.getString("color");

                Material material = new Material();
                material.setName(name);
                material.setPicture(picture);
                material.setPrice(price);
                if (color == null) {
                    color = "standard";
                }
                material.setColor(color);

                materialList.add(material);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
        return materialList;
    }


    /**
     * @param material
     * @throws LoginSampleException The purpose of this method is to save data contained in attributes of parameter material
     *                              in database in materials table
     * @author Magdalena
     */
    public static void addMatDB(Material material) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materials (name,width,thickness,unit,keyword,category,price,picture,spending)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, material.getName());
            ps.setInt(2, material.getWidth());
            ps.setInt(3, material.getThickness());
            ps.setString(4, material.getUnit());
            ps.setString(5, material.getKeyword());
            ps.setString(6, material.getCategory());
            ps.setDouble(7, material.getPrice());
            ps.setString(8, material.getPicture());
            ps.setDouble(9, material.getSpending());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException("Problem while saving in database");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }


    /**
     * @param name
     * @return double
     * @throws LoginSampleException the purpose of this method is to find a value of 'spending' colon in materials table,
     *                              where value of name collon is the parameter
     * @author Magdalena
     */
    public static double spending(String name) throws LoginSampleException {
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
                throw new LoginSampleException("Kunne ikke læse data om forbrug af den valgte materiale til beklædning");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int getWidthByName(String materialName) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT width FROM fogdb.materials WHERE name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, materialName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int width = rs.getInt("width");
                return width;
            } else {
                return 0;
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
            return 0;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static int getVariationID(String color, String materialName) throws LoginSampleException {
        int variationID = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT variationID FROM materials RIGHT JOIN variations ON " +
                    "materials.materialID=variations.materialID WHERE variations.color=? AND materials.name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, color);
            ps.setString(2, materialName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                variationID = rs.getInt("variationID");
                return variationID;
            } else {
                throw new LoginSampleException("Kunne ikke læse data om variationer af denne material: " + materialName);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static int getPackageSize(String name) throws LoginSampleException {
        int size = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT quantity FROM variations LEFT JOIN materials " +
                    "ON materials.materialID=variations.materialID WHERE materials.name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                size = rs.getInt(1);
                return size;
            } else {
                throw new LoginSampleException("Fejl under læsning af pakkestørrelse fra DB");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }

    }

    public static ArrayList<Integer> getLengths(String name) throws LoginSampleException {
        int length;
        ArrayList<Integer> lengths = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT length FROM variations LEFT JOIN materials " +
                    "ON materials.materialID=variations.materialID WHERE materials.name= ? ORDER BY length ASC";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                length = rs.getInt(1);
                lengths.add(length*10);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException("Fejl under læsning af længder fra DB");
        }
        return lengths;
    }

    public static void setUnitFromDB(Material material) throws LoginSampleException {
        String name = material.getName();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT unit FROM fogdb.materials WHERE name=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String unit = rs.getString("unit");
                material.setUnit(unit);

            } else {
                throw new LoginSampleException("Material: "+material.getName() + " mangler unit verdi i databasen");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());

        }
    }

    //....................................End of Magda's......................................//


    //Cath
    public static ArrayList getLengthForMaterials(String materialName) throws LoginSampleException {
        ArrayList<Integer> lengthViaMaterailName = null;
        try {
            Connection con = Connector.connection();
            String SQLRequest = "SELECT variations.length FROM fogdb.variations JOIN fogdb.materials ON materials.materialID = variations.materialID WHERE materials.name=?";
            PreparedStatement preparedStatement = con.prepareStatement(SQLRequest);
            preparedStatement.setString(1, materialName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lengthViaMaterailName.add(resultSet.getInt("length"));
            }
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            throw new LoginSampleException(e.getMessage());
        }

        return lengthViaMaterailName;
    }

    public static String getNameFromMaterialID(int idMaterial) throws LoginSampleException {
        String materialNameByID = null;
        try {
            Connection con = Connector.connection();
            String SQLRequest = "SELECT materials.name FROM fogdb.materials WHERE materials.id=?";
            PreparedStatement preparedStatement = con.prepareStatement(SQLRequest);
            preparedStatement.setInt(1, idMaterial);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                materialNameByID = resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            throw new LoginSampleException(e.getMessage());
        }

        return materialNameByID;
    }

    public static String getColorByID(int variationID) throws LoginSampleException {
        String color = "";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT color FROM variations WHERE variationID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, variationID);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                color = rs.getString("variationID");
                return color;
            } else {
                throw new LoginSampleException("Fejl under læsning af materialefarver fra DB");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
