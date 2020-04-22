package DBAccess;

import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialMapper
{
    // This class Connects to DB and gets the "material" data from it.
    public class InfoMapper {
        //1. create a method that returns a list of Info objs - Info = Class from function Layer
        public static List<Info> getAllInfos() throws LoginSampleException
        {
            List<Info> infoList = null; //create an empty list 'infoList'

            //try-catch block in case an error occurs.
            try
            {
                //2. start the connection by calling ".connection()" method from the "Connector" class
                Connection con = Connector.connection();
                //3. create an SQL statement - select all from the 'info' table
                String SQL = "SELECT * FROM info";
                //4. insert the SQL statement into the ".preparedStatment()" method - it sends the SQL statement to the DB
                PreparedStatement ps = con.prepareStatement(SQL);
                //5. call the ".executeQuery()" to execute the SQL statement and return the result (stored in ResultSet).
                ResultSet rs = ps.executeQuery();//works with getters/setters from "Info" class

                //6. while there is a next 'rs' (result i.e element) - do the following code
                while (rs.next())
                {
                    //if the 'infoList' is empty
                    if (infoList == null) {
                        infoList = new ArrayList<>(); //design choice - to easily switch to ArrayList implementation

                    }
                    //get the result of the 'info_id' and 'name' (the data rows)
                    int info_id = rs.getInt("info_id");
                    String name = rs.getString("name");
                    //create a new info obj of 'Info' class and pass the gotten data in it (info_id & name)
                    Info info = new Info(info_id, name);// data gets stored in 'info'
                    //add the gotten 'info' data to the 'InfoList'
                    infoList.add(info);
                }
            }
            //catch the SQLException
            catch(ClassNotFoundException | SQLException ex )
            {
                throw new LoginSampleException(ex.getMessage()); //get the error message
            }
            // return the gotten 'info' data from the DB
            return infoList;
        }
    }
}
