package stats.count;
import java.sql.*;
public class CountByNonVeg implements Count{
    public static void count(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from menu group by FOOD_TYPE having FOOD_TYPE='NON_VEG' ");
            if (rs.next() == false) {
                System.out.println("No Result");
              } else {
        
                do {
                    System.out.println( rs.getString(1)+ " Non-Vegetarians");
                } while (rs.next());
              }
            
                
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
        
    }    
}
