package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector2 {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ((singleton == null) || singleton.isClosed()) {
            setDBCredentials();
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;
    }

    public static void setDBCredentials() {
        // Prod: hent variabler fra setenv.sh i Tomcats bin folder
        URL = "jdbc:mysql://localhost:3306/fogDB?serverTimezone=CET&allowPublicKeyRetrieval=true&useSSL=false";
        USERNAME = "root";
        PASSWORD = "Kat4Kanin5Hund1Hamster1";

    }

}
