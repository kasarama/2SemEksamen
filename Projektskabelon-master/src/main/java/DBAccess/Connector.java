package DBAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    public class Connector
    {
        private static final String URL = "jdbc:mysql://64.225.76.1:3306/useradmin?";
        private static final String USERNAME = "bmi";
        private static final String PASSWORD = "Bmi_Admin_#_12";

        private static Connection singleton;
        public static void setConnection( Connection con ) {
            singleton = con;
        }
        public static Connection connection() throws ClassNotFoundException, SQLException {
            if ( singleton == null ) {
                Class.forName( "com.mysql.cj.jdbc.Driver" );
                singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
            }
            return singleton;
        }

    }
}
// Contains method that reads MySql pwd/usr

    /*

public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ((singleton == null) || singleton.isClosed()) {
            setDBCredentials();
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

    // method that reads the MySQL password/username from an external txt file - Security

    public static void setDBCredentials() {
        String[] data= readData();
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null){
            // Prod: hent variabler fra setenv.sh i Tomcats bin folder
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {
            // Localhost
            URL = "jdbc:mysql://localhost:3306/fogDB?serverTimezone=CET&useSSL=false";
            USERNAME = data[0];
            PASSWORD = data[1];
        }
    }

    public static String[] readData() {

        String[] data = new String[2];
        File file = new File("c:/dbAccess/dbAccess.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            data = line.split(";");

        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("File notfound: " + file.toString());
        }
        return data;

    }

     */

