package Orders.order;
import java.util.ArrayList;
import java.sql.*;
import Orders.item.*;



public class OrderList {
    private static ArrayList<Item> Lists = new ArrayList<>();

    public static void printOrder()
    {
        if(Lists.size()==0)
        {
            System.out.println("No Food ordered");
        }
        else
        {   int total=0;
            for (Item i : Lists) {
                System.out.println(i);
                total=i.getPrice()*i.getQuantity();
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
        

        // execute the preparedstatement
        ResultSet rs = preparedStmt.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+Integer.parseInt(args[3]));
        Item I1=new Item(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),Integer.parseInt(args[3]));
        Lists.add(I1);
        int total=0;
            for (Item i : Lists) {
                System.out.println(i);
                total=i.getPrice()*i.getQuantity();
            }
            System.out.println("Total is: Rs."+total);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Wrong Format");
        }
        return 1;

    }
    public static void cancelOrder() {
        if(Lists.size()==0)
        {
            System.out.println("No Food ordered");
        }
        else
        {
            System.out.println("Whole order canceled successfully!!!");
            Lists.clear();
        }
    }
    public static void cancelOrder(int id)
    {
        if(Lists.size()==0)
        {
            System.out.println("No Food ordered");
        }
        else
        {
            
            for (Item i : Lists) {
                if(i.getFood_Id()==id)
                {
                    Lists.remove(i);
            System.out.println("Order canceled successfully!!!");

                    return;
                }
              }
            System.out.println("Order is not present");

        }
    }
    // public static static void main(String[] args) {
    //     System.out.println("working");
    // }
}
