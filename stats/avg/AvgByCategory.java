package stats.avg;

import java.sql.*;

public class AvgByCategory implements Avg {
    public static void avg(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Category,avg(price) from menu group by Category");
            if (rs.next() == false) {
                System.out.println("No Result");
            } else {

                do {
                    System.out.println("Average price for category " + rs.getString(1) + " is " + rs.getDouble(2));
                } while (rs.next());
            }

        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }

    }
}
