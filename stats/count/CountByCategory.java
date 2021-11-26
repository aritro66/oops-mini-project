package stats.count;

import java.sql.*;

public class CountByCategory implements Count {
    public static void count(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select Category,count(*) from menu group by Category");
            if (rs.next() == false) {
                System.out.println("No Result");
            } else {

                do {
                    System.out.println(rs.getString(1) + " " + rs.getInt(2));
                } while (rs.next());
            }

        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }

    }
}
