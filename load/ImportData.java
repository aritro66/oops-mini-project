package load;
import java.io.*;
import java.sql.*;

public class ImportData {
    public static void loadData(Connection con) {
        // Statement stmt = con.createStatement();
        // ResultSet rs = stmt.executeQuery("show tables");
        System.out.println("Working");
        // while (rs.next()) {
        //     if (rs.getString(1).toLowerCase().equals("menu")) {
        //         System.out.println("found");
        //         return;
        //     }
        // }
        String line = "";
        String splitBy = ",";
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("Menu.csv"));
            Statement stmt2 = con.createStatement();
            String sql = "CREATE TABLE menu(FOOD_ID INT NOT NULL AUTO_INCREMENT,FOOD_NAME varchar(40),CATEGORY varchar(20),FOOD_TYPE varchar(20),PRICE int,PRIMARY KEY (FOOD_ID))";
            String sql2 = "CREATE TABLE menu_order(FOOD_ID INT NOT NULL,FOOD_NAME varchar(40),CATEGORY varchar(20),FOOD_TYPE varchar(20),PRICE int,QUANTITY int,ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (FOOD_ID))";
            String sql3="drop table if exists menu_order";
            String sql4="drop table if exists menu";
            stmt2.executeUpdate(sql3);
            stmt2.executeUpdate(sql4);
            stmt2.executeUpdate(sql);
            stmt2.executeUpdate(sql2);
            line = br.readLine();
            while ((line = br.readLine()) != null) 
            {
                String[] employee = line.split(splitBy); 
                
                String query = " insert into menu(FOOD_NAME,CATEGORY,FOOD_TYPE,PRICE) values (?, ?, ?, ?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, employee[1]);
                preparedStmt.setString(2, employee[2]);
                preparedStmt.setString(3, employee[3]);
                preparedStmt.setInt(4, Integer.parseInt(employee[4]));

                // execute the preparedstatement
                preparedStmt.execute();
            }
            System.out.println("table formed");
            br.close();
        } catch (Exception e) {
            // System.out.println("Table could not formed");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
