package stats.count;
import java.sql.*;

public class CountByVeg implements Count{
    public static void count(Connection con){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from menu group by FOOD_TYPE having FOOD_TYPE='VEG' ");
            System.out.println("Working");
            while (rs.next())
                System.out.println( rs.getString(1)+ " Vegetarians");
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
        
    }    
}
