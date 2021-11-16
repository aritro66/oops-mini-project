package operation.update;
import java.sql.*;

public class Update {
    public static void insertRecord(Connection con,String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
            // ResultSet rs = stmt.executeQuery("select * from menu");
            System.out.println("Working");
            String query = "update menu set price = price + ? where name = ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, args[1]);
      preparedStmt.setString(2, args[2]);
      preparedStmt.setString(3, args[3]);
      preparedStmt.setInt(4, Integer.parseInt(args[4]));
      

      // execute the preparedstatement
      preparedStmt.execute();
            
    }
}