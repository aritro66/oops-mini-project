package stats.avg;
import java.sql.*;
public class AvgByCategory implements Avg{
    public static void avg(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Category,avg(price) from menu group by Category");
            System.out.println("Working");
            while (rs.next())
                System.out.println("Average price for category "+ rs.getString(1)+" is "+rs.getDouble(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
