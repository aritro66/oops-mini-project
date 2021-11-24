package stats.avg;
import java.sql.*;

public class AvgByVeg implements Avg {
    public static void avg(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select avg(price) from menu group by FOOD_TYPE having FOOD_TYPE='VEG'");
            System.out.println("Working");
            while (rs.next())
                System.out.println( "Average price for Veg is "+rs.getString(1));
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
    }
}
