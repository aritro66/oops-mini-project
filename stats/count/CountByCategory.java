package stats.count;
import java.sql.*;
public class CountByCategory {
    public static void countCatagory(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Category,count(*) from menu group by Category");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1)+" "+rs.getInt(2));
    }
}
