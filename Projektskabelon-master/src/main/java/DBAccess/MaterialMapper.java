package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;

import java.sql.*;

public class MaterialMapper {

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
                Material material = new Material( name, size, unit );
                return material;
            } else {
                throw new LoginSampleException( "Could not find the material" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
