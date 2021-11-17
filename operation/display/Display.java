package operation.display;
import java.sql.*;
import java.util.Formatter;

public class Display {
    public static void displayAll(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu");
            System.out.println("Working");
            
            while (rs.next())
            {
                Formatter formatter = new Formatter();

                // Use Space format specifier
                formatter.format("%-4s%-35s%-25s%-15s%-15s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                // System.out.printf();
                System.out.println(formatter);
                // System.out.printf();
            }
    }
    public static void displayCatagories(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select distinct Category from menu");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1));
    }
}
