package projectMan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    Connection con=null;
    static String dbname="ProjectMan";
   public static Connection connect()
    {
        try {
            String url = "jdbc:mysql://localhost:3306/" + dbname + "?useSSL=false";
            Connection con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connected");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
