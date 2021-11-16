package operation.display;
import java.sql.*;

public class Display {
    public static void displayAll(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from members");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getInt(1) + "  " + rs.getString(2) + "  "+rs.getString(3));
    }
    public static void displayCatagories(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct Category from menu");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1));
    }
}
