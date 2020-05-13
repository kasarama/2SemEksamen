package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setUserID(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID, name, role FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                int id = rs.getInt("userID");
                User user = new User(name, email, password, role);
                user.setUserID(id);
                return user;
            } else {
                throw new LoginSampleException("Kunne ikke finde brugeren.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int getIDbyEmail(String email) throws LoginSampleException {
        int id = 0;
            try {
            Connection con = Connector.connection();
            String SQL = "SELECT userID FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("userID");
            } else {
                throw new LoginSampleException("Vi kunne ikke finde dig i vores database. Kontakt butikken");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());

        }

        return id;
    }

    public static String getEmailByID (int id) throws LoginSampleException {
        String email="";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT email FROM users WHERE userID=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");
            } else {
                throw new LoginSampleException("Vi kunne ikke finde email for ID: "+id+" i vores database. Kontakt IT dream team");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());

        }

        return email;
    }
}
