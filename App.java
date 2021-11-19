import java.io.*;
import java.sql.*;
import connection.*;
import Orders.order.*;
import operation.update.*;
import operation.display.*;
import operation.insert.*;
import operation.delete.*;
import stats.count.*;
import stats.avg.*;

public class App {

    public static Connection con = null;

    public static void loadData() throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("show tables");
        System.out.println("Working");
        while (rs.next()) {
            if (rs.getString(1).toLowerCase().equals("menu")) {
                System.out.println("found");
                return;
            }
        }
        String line = "";
        String splitBy = ",";
        try {
            
            BufferedReader br = new BufferedReader(new FileReader("Menu.csv"));
            Statement stmt2 = con.createStatement();
            String sql = "CREATE TABLE menu(FOOD_ID INT NOT NULL AUTO_INCREMENT,FOOD_NAME varchar(40),CATEGORY varchar(20),FOOD_TYPE varchar(20),PRICE int,PRIMARY KEY (FOOD_ID))";

            stmt2.executeUpdate(sql);
            
            String sql2 = "CREATE TABLE menu_order(FOOD_ID INT NOT NULL,FOOD_NAME varchar(40),CATEGORY varchar(20),FOOD_TYPE varchar(20),PRICE int,QUANTITY int,PRIMARY KEY (FOOD_ID))";

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

    

    public static void printHelp() {
        System.out.println("Help for commands:");
        // System.out.println("-a <filename> for operation A on filename");
        // System.out.println("-b <recordType> <string> for operation on <recordType>
        // and search <string>");
        System.out.println("-h (or any) for help menu");
        System.out.println("-d all (shows all menu)");
        // System.out.println("-d all (shows all menu)");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        

        System.out.println(args.length);
        
        switch (args[0]) {
        case "-l":
            con=Connections.getConnection();
            loadData();
            Connections.disconnect(con);
            break;
        case "-s":
            switch (args[1]) {
            case "all":
                con = Connections.getConnection();
                Display.displayAll(con);
                Connections.disconnect(con);
                break;
            case "cat":
                con = Connections.getConnection();
                Display.displayCatagories(con, args[2]);
                Connections.disconnect(con);
                break;
            case "type":
                con = Connections.getConnection();
                Display.displayType(con, args[2]);
                Connections.disconnect(con);
                break;
            case "range":
            switch (args[2]) {
                case "-e":
                con = Connections.getConnection();
                Display.displayPriceEqual(con, args[3]);
                Connections.disconnect(con);
                    break;
                case "-g":
                con = Connections.getConnection();
                Display.displayPriceGreater(con, args[3]);
                Connections.disconnect(con);
                break;
                case "-ge":
                con = Connections.getConnection();
                Display.displayPriceGreaterEqual(con, args[3]);
                Connections.disconnect(con);
                break;
                case "-l":
                con = Connections.getConnection();
                Display.displayPriceLesser(con, args[3]);
                Connections.disconnect(con);
                break;
                case "-le":
                con = Connections.getConnection();
                Display.displayPriceLesserEqual(con, args[3]);
                Connections.disconnect(con);
                break;
                default:
                    break;
            }
            break;
            default:
                printHelp();

                break;
            }
            break;
        case "-i":
            con = Connections.getConnection();
            Insert.insertRecord(con, args);
            Connections.disconnect(con);
            break;
        case "-count":
            switch (args[1]) {

            case "cat":
                con = Connections.getConnection();

                CountByCategory.count(con);
                Connections.disconnect(con);
                break;
            case "veg":
                con = Connections.getConnection();

                CountByVeg.count(con);
                Connections.disconnect(con);
                break;
            case "nonveg":
                con = Connections.getConnection();

                CountByNonVeg.count(con);
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-avg":
            switch (args[1]) {

            case "cat":
                con = Connections.getConnection();

                AvgByCategory.avg(con);
                Connections.disconnect(con);
                break;
            case "veg":
                con = Connections.getConnection();

                AvgByVeg.avg(con);
                Connections.disconnect(con);
                break;
            case "nonveg":
                con = Connections.getConnection();

                AvgByNonAvg.avg(con);
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }

            break;
        case "-u":
            switch (args[1]) {

            case "cat":
                con = Connections.getConnection();

                Update.updateByCategory(con, args);
                Connections.disconnect(con);
                break;
            case "veg":
                con = Connections.getConnection();

                Update.updateByVeg(con, args);
                Connections.disconnect(con);
                break;
            case "nonveg":
                con = Connections.getConnection();

                Update.updateByNonVeg(con, args);
                Connections.disconnect(con);
                break;
            case "id":
                con = Connections.getConnection();

                Update.updateByFoodId(con, args);
                Connections.disconnect(con);
                break;
            case "all":
                con = Connections.getConnection();

                Update.updateAll(con, args);
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-o":
            switch (args[1]) {

            case "create":
                con = Connections.getConnection();
                OrderList.createOrder(con, args);
                Connections.disconnect(con);
                break;
            case "show":
                con = Connections.getConnection();

                OrderList.printOrder(con);
                Connections.disconnect(con);
                break;
            case "cone":
                con = Connections.getConnection();

                OrderList.cancelOrder(con,Integer.parseInt(args[2]));
                Connections.disconnect(con);
                break;
            case "call":
                con = Connections.getConnection();

                OrderList.cancelOrder(con);
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-d":
        con = Connections.getConnection();

                Delete.deleteRecord(con,args);
                Connections.disconnect(con);
        break;
        case "-h":
            printHelp();
            break;
        default:
            printHelp();
            break;
        }
    }
}