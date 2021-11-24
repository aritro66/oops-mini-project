package stats.count;
import java.sql.*;
public class CountByNonVeg implements Count{
    public static void count(Connection con) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from menu group by FOOD_TYPE having FOOD_TYPE='NON_VEG' ");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1)+ " Non-Vegetarians");
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
        
    }    
}
