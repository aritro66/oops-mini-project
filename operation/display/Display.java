package operation.display;
import java.sql.*;


public class Display {
    public static void displayAll(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu");
            System.out.println("Working");
            System.out.println(rs);
            while (rs.next())
            {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void displayCatagories(Connection con,String category) {
        try {
            String query="select * from menu where CATEGORY = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, category);   
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static void displayType(Connection con,String type) {
        try {
            String query="select * from menu where FOOD_TYPE= ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, type);
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static void displayPriceGreater(Connection con,String price) {
        try {
            String query="select * from menu where PRICE > ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(price));
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static void displayPriceGreaterEqual(Connection con,String price) {
        try {
            String query="select * from menu where PRICE >= ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(price));
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static void displayPriceEqual(Connection con,String price) {
        try {
            String query="select * from menu where PRICE = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(price));
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    public static void displayPriceLesser(Connection con,String price) {
        try {
            String query="select * from menu where PRICE < ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(price));
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void displayPriceLesserEqual(Connection con,String price) {
        try {
            String query="select * from menu where PRICE <= ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(price));
            ResultSet rs =preparedStmt.executeQuery();
            System.out.println("Working");
            while (rs.next()) {
                System.out.printf("%-4s%-35s%-25s%-25s%-15s\n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));  
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
