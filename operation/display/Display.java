package operation.display;
import java.sql.*;
import java.util.Formatter;

public class Display {
    public static void displayAll(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu");
            System.out.println("Working");
            
            System.out.println(rs);
            while (rs.next())
            {
                Formatter formatter = new Formatter();

                // Use Space format specifier
                formatter.format("%-4s%-35s%-25s%-25s%-15s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                // System.out.printf();
                System.out.println(formatter);
                // System.out.printf();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void displayCatagories(Connection con,String category) {
        try {
            // Statement stmt = con.createStatement();
            String query="select * from menu where CATEGORY = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, category);
            // ResultSet rs = stmt.executeQuery("select * from menu where CATEGORY="+category);
            
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                Formatter formatter = new Formatter();

                // Use Space format specifier
                formatter.format("%-4s%-35s%-25s%-25s%-15s", rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5));
                System.out.println(formatter);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static void displayType(Connection con,String type) {
        try {
            // Statement stmt = con.createStatement();
            // ResultSet rs = stmt.executeQuery("select * from menu where FOOD_TYPE="+type);
            String query="select * from menu where FOOD_TYPE= ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, type);
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                Formatter formatter = new Formatter();

                // Use Space format specifier
                formatter.format("%-4s%-35s%-25s%-25s%-15s", rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5));
                System.out.println(formatter);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
