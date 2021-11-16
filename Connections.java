import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/menu", "root", "admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}


