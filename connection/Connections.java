package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy", "root", "admin");
        } catch (Exception e) {
            System.out.println("Unable to connect");

        }
        return conn;
    }

    public static void disconnect(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Unable to disconnect");

        }
    }
}
