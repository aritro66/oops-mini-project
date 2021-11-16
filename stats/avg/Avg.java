package stats.avg;
import java.sql.*;
public class Avg {
    public static void countAvg(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Category,avg(price) from menu group by Category");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1)+" "+rs.getDouble(2));
    }
}
