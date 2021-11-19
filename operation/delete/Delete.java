package operation.delete;
import java.sql.*;

public class Delete {
    public static void deleteRecord(Connection con, String[] args) {
        try {
            System.out.println("Working");
            String query = "delete from menu where FOOD_Id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(args[1]));
            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
