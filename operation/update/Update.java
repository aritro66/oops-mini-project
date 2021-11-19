package operation.update;

import java.sql.*;

public class Update {
    public static void updateByFoodId(Connection con, String[] args) throws SQLException {
        
        System.out.println("Working");
        String query = "update menu set price = price + ? where Food_Id = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[3]));
        preparedStmt.setInt(2, Integer.parseInt(args[2]));
        preparedStmt.execute();

    }

    public static void updateByVeg(Connection con, String[] args) throws SQLException {
        
        System.out.println("Working");
        String query = "update menu set price = price + ? where Food_Type = 'VEG' ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[2]));
        preparedStmt.execute();

    }

    public static void updateByNonVeg(Connection con, String[] args) throws SQLException {
    
        System.out.println("Working");
        String query = "update menu set price = price + ? where Food_Type = 'NON_VEG' ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[2]));
        preparedStmt.execute();

    }

    public static void updateByCategory(Connection con, String[] args) throws SQLException {

        System.out.println("Working");
        String query = "update menu set price = price + ? where Category = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[3]));
        preparedStmt.setString(2, args[2]);
        preparedStmt.execute();

    }

    public static void updateAll(Connection con, String[] args) throws SQLException {

        System.out.println("Working");
        String query = "update menu set price = price + ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[2]));
        preparedStmt.execute();

    }

}