package Orders.order;
import java.util.*;
import java.sql.*;
import Orders.item.*;



public class OrderList {
    private static ArrayList<Item> Lists = new ArrayList<>();

    public static void printOrder(Connection con)
    {
        try {
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from menu_order");
            System.out.println("Working");
            
            
            while (rs.next())
            {
                Item I1=new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
                Lists.add(I1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(Lists.size()==0)
        {
            System.out.println("No Food ordered");
        }
        else
        {   
            int total=0;
            for (Item i : Lists) {
                System.out.println(i);
                total+=i.getPrice()*i.getQuantity();
            }
            System.out.println("Total is: Rs."+total);
        }
    }
    public static int createOrder(Connection con,String[] args)
    {
        
        try {
            String query = "select * from menu where Food_Id = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, Integer.parseInt(args[2]));
        
        
        ResultSet rs = preparedStmt.executeQuery();
        rs.next();
        
        String query2 = " insert into menu_order values (?, ?, ?, ?, ?, ?)";
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
            System.out.println(e);
            System.out.println("Wrong Format");
        }
        return 1;

    }
    public static void cancelOrder(Connection con) {
        
        try {
            Statement stmt2 = con.createStatement();
            String sql = "TRUNCATE TABLE menu_order";

            stmt2.executeUpdate(sql);
            System.out.println("Whole order cancelled successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void cancelOrder(Connection con,int id)
    {
        try {
            System.out.println("Working");
            String query = "delete from menu_order where FOOD_Id=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
