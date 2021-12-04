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
                for (int i = 0; i < 40; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("| %-25s| %-10s|\n", "Category", "Count");
                for (int i = 0; i < 40; i++) {
                    System.out.print("-");
                }
                System.out.println();
                do {
                    System.out.printf("| %-25s| %-10s|\n", rs.getString(1), rs.getInt(2));
                } while (rs.next());
                for (int i = 0; i < 40; i++) {
                    System.out.print("-");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }

    }
}
