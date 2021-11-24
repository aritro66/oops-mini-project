package operation.delete;
import java.sql.*;

public class Delete {
    public static void deleteRecord(Connection con, String[] args) {
        try {
            String query = "delete from menu where FOOD_Id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(args[1]));
            int rs=preparedStmt.executeUpdate();
            if(rs==0)
            {
                System.out.println("Id "+args[1]+" not presnt in menu");
            }
            else
            {
                System.out.println("Deleted");

            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }

    }
}
