package Orders.order;

import java.util.*;
import java.sql.*;
import Orders.item.*;

public class OrderList {
    private static ArrayList<Item> Lists = new ArrayList<>();
    private static ArrayList<ItemMoreInfo> ListsMore = new ArrayList<>();

    public static void printOrder(Connection con) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu_order");
            while (rs.next()) {
                Item I1 = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7));
                Lists.add(I1);
            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
        if (Lists.size() == 0) {
            System.out.println("No Food ordered");
        } else {
            int total = 0;
            for (Item i : Lists) {
                System.out.println(i + i.generateDate());
                total += i.getPrice() * i.getQuantity();
            }
            System.out.println("Total: Rs." + total*1.0);
            System.out.println("Service Charge: Rs." + total*0.1);
            System.out.println("GST: Rs." + total*0.18);
            System.out.println("Total Amount Payable: Rs." + total*1.28);
        }
    }

    public static void printOrderMore(Connection con) {
        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu_order");
            while (rs.next()) {
                ItemMoreInfo I1 = new ItemMoreInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getString(7));
                ListsMore.add(I1);
            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
        if (ListsMore.size() == 0) {
            System.out.println("No Food ordered");
        } else {
            int total = 0;
            for (ItemMoreInfo i : ListsMore) {
                System.out.println(i + i.generateDate());
                total += i.getPrice() * i.getQuantity();
            }
            System.out.println("Total: Rs." + total*1.0);
            System.out.println("Service Charge: Rs." + total*0.1);
            System.out.println("GST: Rs." + total*0.18);
            System.out.println("Total Amount Payable: Rs." + total*1.28);
        }
    }

    public static int createOrder(Connection con, String[] args) {

        try {
            String query = "select * from menu where Food_Id = ? ";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(args[2]));
            ResultSet rs = preparedStmt.executeQuery();
            rs.next();
            String query2 = " insert into menu_order(Food_Id,Food_Name,Category,Food_Type,Price,Quantity) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt2 = con.prepareStatement(query2);
            preparedStmt2.setInt(1, rs.getInt(1));
            preparedStmt2.setString(2, rs.getString(2));
            preparedStmt2.setString(3, rs.getString(3));
            preparedStmt2.setString(4, rs.getString(4));
            preparedStmt2.setInt(5, rs.getInt(5));
            preparedStmt2.setInt(6, Integer.parseInt(args[3]));
            preparedStmt2.execute();
            System.out.println("Successfully Added!!!");

        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }
        return 1;

    }

    public static void cancelOrder(Connection con) {

        try {
            Statement stmt2 = con.createStatement();
            String sql = "DELETE FROM menu_order";
            int rs=stmt2.executeUpdate(sql);
            if(rs==0)
            {
                System.out.println("No orders placed");
            }
            else
            {
                System.out.println("Whole order cancelled successfully!!!");
            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");

        }

    }

    public static void cancelOrder(Connection con, int id) {
        try {
            String query = "delete from menu_order where FOOD_Id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            int rs=preparedStmt.executeUpdate();
            if(rs==0)
            {
                System.out.println("Id "+id+" not present in menu_order");
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
