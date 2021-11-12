package operation.insert;
import java.sql.*;

public class Insert {
    public static void insertRecord(Connection con,String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
            // ResultSet rs = stmt.executeQuery("select * from menu");
            System.out.println("Working");
            String query = " insert into menu values (?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, args[1]);
      preparedStmt.setString(2, args[2]);
      preparedStmt.setInt(3, Integer.parseInt(args[3]));
      

      // execute the preparedstatement
      preparedStmt.execute();
            
    }
}
