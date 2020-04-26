package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.*;

public class MaterialMapper
{

    // Skal have fat i et materiale ud fra note

    // Vi vil vide hvor meget materiale der skal bruges

    public static Material getMaterial(String keyword) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT name, size, unit FROM fogdb.materials "
                    + "WHERE keyword=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, keyword );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String name = rs.getString( "name" );
                int size = rs.getInt( "size" );
                String unit = rs.getString( "unit" );
                Material material = new Material(0, name, size, unit,null ,null);
                return material;
            } else {
                throw new LoginSampleException( "Could not find the material" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }



// This class Connects to DB and gets the "Roof material" data from it.

        //1. create a method that returns a list of ROOF Materials -  Material = Class from function Layer
        public static List<Material> getAllRoofMaterials() throws LoginSampleException
        {
            List<Material> materialList = null;

            //try-catch block in case an error occurs.
            try
            {
                //2. start the connection by calling ".connection()" method from the "Connector" class
                Connection con = Connector.connection();
                //3. create an SQL statement - select only 'tag' from the 'material' table
                String SQL = "SELECT * FROM materials WHERE category = 'tag'";
                //4. insert the SQL statement into the ".preparedStatement()" method - it sends the SQL statement to the DB
                PreparedStatement ps = con.prepareStatement(SQL);
                //5. call the ".executeQuery()" to execute the SQL statement and return the result (stored in ResultSet).
                ResultSet rs = ps.executeQuery();//works with getters/setters from "Info" class

                //6. while there is a next 'rs' (result i.e element) - do the following code
               while (rs.next())
                {

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
            catch(ClassNotFoundException | SQLException ex )
            {
                throw new LoginSampleException(ex.getMessage()); //get the error message
            }
            // return the gotten 'material' data from the DB
            return materialList;
        }

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
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new LoginSampleException("Problem while saving in database");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw  new LoginSampleException(ex.getMessage());
        }

    }


}

