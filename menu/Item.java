package menu;
import java.sql.*;
import java.util.*;

public class Item extends Menu {

    public Item(String food_Name, String category, String food_Type, int price) {
        super(food_Name, category, food_Type, price);
        
    }
    public void insertRecord(Connection con) {

        try {
            System.out.println("Working");
            String query = " insert into menu(FOOD_NAME,CATEGORY,FOOD_TYPE,PRICE) values (?, ?, ?, ?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, this.getFood_Name());
            preparedStmt.setString(2, this.getCategory());
            preparedStmt.setString(3, this.getFood_Type());
            preparedStmt.setInt(4, this.getPrice());

            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void displayAll(Connection con) throws SQLException {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu");
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

    public void displayCatagories(Connection con,String category) throws SQLException {
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
    public void displayType(Connection con,String type) throws SQLException {
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
    public void updateByFoodId(Connection con, String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from menu");
        System.out.println("Working");
        String query = "update menu set price = price + ? where Food_Id = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[3]));
        preparedStmt.setInt(2, Integer.parseInt(args[2]));

        // execute the preparedstatement
        preparedStmt.execute();

    }

    public void updateByVeg(Connection con, String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from menu");
        System.out.println("Working");
        String query = "update menu set price = price + ? where Food_Type = 'VEG' ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[2]));

        // execute the preparedstatement
        preparedStmt.execute();

    }

    public void updateByNonVeg(Connection con, String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from menu");
        System.out.println("Working");
        String query = "update menu set price = price + ? where Food_Type = 'NON_VEG' ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[2]));

        // execute the preparedstatement
        preparedStmt.execute();

    }

    public void updateByCategory(Connection con, String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from menu");
        System.out.println("Working");
        String query = "update menu set price = price + ? where Category = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[3]));
        preparedStmt.setString(2, args[2]);


        // execute the preparedstatement
        preparedStmt.execute();

    }

    public void updateAll(Connection con, String[] args) throws SQLException {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("select * from menu");
        System.out.println("Working");
        String query = "update menu set price = price + ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);

        preparedStmt.setInt(1, Integer.parseInt(args[2]));

        // execute the preparedstatement
        preparedStmt.execute();

    }
    public static void deleteRecord(Connection con,String[] args) throws SQLException {

        System.out.println("Working");
        String query = "delete from menu where FOOD_Id=?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
  preparedStmt.setInt(1, Integer.parseInt(args[1]));
  preparedStmt.execute();
    
}
}
