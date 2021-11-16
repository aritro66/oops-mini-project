package stats.count;
import java.sql.*;
public class CountByNonVeg {
    public static void countNonVeg(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from menu group by VEG_NONVEG_NA having VEG_NONVEG_NA='NON-VEG' ");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1)+ " Non-Vegetarians");
    }    
}
