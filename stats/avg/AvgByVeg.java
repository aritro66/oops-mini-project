package stats.avg;

import java.sql.*;

public class AvgByVeg implements Avg {
    public static void avg(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select avg(price) from menu group by FOOD_TYPE having FOOD_TYPE='VEG'");
            if (rs.next() == false) {
                System.out.println("No Result");
            } else {

                do {
                    System.out.println("Average price for Veg is " + rs.getString(1));
                } while (rs.next());
            }

        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
    }
}
