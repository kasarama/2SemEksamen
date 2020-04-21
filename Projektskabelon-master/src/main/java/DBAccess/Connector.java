package DBAccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 The purpose of Connector is to...

 @author kasper
 */
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

    public static void setDBCredentials() {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null){
            // Prod: hent variabler fra setenv.sh i Tomcats bin folder
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {
            System.out.println("In else statement");
            ArrayList<String> data=passwordReader();
            // Localhost
            URL = "jdbc:mysql://localhost:3306/cupcake?serverTimezone=UTC";
            USERNAME = data.get(0);
            PASSWORD = data.get(1);
        }
    }

    public static ArrayList<String> passwordReader() {
        ArrayList<String> data = new ArrayList();
        System.out.println("In that wonderfull method");
        try {
            //  Projektskabelon-master/src/main/java/DBAccess/Connector.java
            File myObj = new File("C:\\DBAccess\\dbAccess.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String linie = myReader.nextLine();
                data.add(linie);
                System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
    }
