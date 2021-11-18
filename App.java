import java.io.*;
import java.sql.*;
import connection.*;
import Orders.order.*;
import operation.update.*;
import operation.display.*;
import operation.insert.*;
import stats.count.*;
import stats.avg.*;

public class App {

    public static Connection con = null;

    // public static void doOperationA(String args[]){
    // System.out.println("Doing operation A with "+args[1]+" argument");
    // }
    // public static void doOperationB(String args[]){
    // System.out.println("Doing operation B with "+args[1]+" "+args[2]+"
    // argument");
    // }
    // public static void con=Connections.getConnection() throws SQLException,
    // ClassNotFoundException {
    // Class.forName("com.mysql.cj.jdbc.Driver");
    // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy",
    // "root", "admin");
    // // here sonoo is database name, root is username and password
    // // Statement stmt = con.createStatement();
    // // ResultSet rs = stmt.executeQuery("select * from emp");
    // // System.out.println("Working");
    // // while (rs.next())
    // // System.out.println( rs.getString(1) + " " + rs.getString(1) + "
    // // "+rs.getInt(3));

    // }

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
            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("Menu.csv"));
            Statement stmt2 = con.createStatement();
            String sql = "CREATE TABLE menu(FOOD_ID INT NOT NULL AUTO_INCREMENT,FOOD_NAME varchar(40),CATEGORY varchar(20),FOOD_TYPE varchar(20),PRICE int,PRIMARY KEY (FOOD_ID))";

            stmt2.executeUpdate(sql);
            line = br.readLine();
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] employee = line.split(splitBy); // use comma as separator
                // System.out.println(employee);
                // Formatter formatter = new Formatter();

                // // Use Space format specifier
                // formatter.format("%-35s%-25s%-15s%-15s",employee[0],employee[1],employee[2],employee[3]);
                // // System.out.printf();
                // System.out.println(formatter);
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
        } catch (Exception e) {
            System.out.println("Table could not formed");
        }
    }

    // public static void Connections.disconnect(con) throws SQLException {
    // con.close();
    // }

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

        Insert obj2 = new Insert();

        System.out.println(args.length);
        // con=Connections.getConnection();
        // loadData();
        // Connections.disconnect(con);

        switch (args[0]) {
        case "-d":
            switch (args[1]) {
            case "all":
                con = Connections.getConnection();
                Display.displayAll(con);
                Connections.disconnect(con);
                break;
            case "cat":
                con = Connections.getConnection();
                // Display obj=new Display();
                Display.displayCatagories(con, args[2]);
                Connections.disconnect(con);
                break;
            case "type":
                con = Connections.getConnection();
                // Display obj=new Display();
                Display.displayType(con, args[2]);
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-i":
            con = Connections.getConnection();
            obj2.insertRecord(con, args);
            Connections.disconnect(con);
            break;
        case "-count":
            switch (args[1]) {

            case "cat":
                con = Connections.getConnection();
                // Display obj=new Display();
                CountByCategory.count(con);
                Connections.disconnect(con);
                break;
            case "veg":
                con = Connections.getConnection();

                // Display obj=new Display();
                CountByVeg.count(con);
                Connections.disconnect(con);
                break;
            case "nonveg":
                con = Connections.getConnection();
                // Display obj=new Display();
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
                // Display obj=new Display();
                AvgByCategory.avg(con);
                Connections.disconnect(con);
                break;
            case "veg":
                con = Connections.getConnection();
                // Display obj=new Display();
                AvgByVeg.avg(con);
                Connections.disconnect(con);
                break;
            case "nonveg":
                con = Connections.getConnection();
                // Display obj=new Display();
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
                // Display obj=new Display();
                Update.updateByCategory(con, args);
                Connections.disconnect(con);
                break;
            case "veg":
                con = Connections.getConnection();
                // Display obj=new Display();
                Update.updateByVeg(con, args);
                Connections.disconnect(con);
                break;
            case "nonveg":
                con = Connections.getConnection();
                // Display obj=new Display();
                Update.updateByNonVeg(con, args);
                Connections.disconnect(con);
                break;
            case "id":
                con = Connections.getConnection();
                // Display obj=new Display();
                Update.updateByFoodId(con, args);
                Connections.disconnect(con);
                break;
            case "all":
                con = Connections.getConnection();
                // Display obj=new Display();
                Update.updateAll(con, args);
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-h":
            printHelp();
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
                // Display obj=new Display();
                OrderList.printOrder();
                Connections.disconnect(con);
                break;
            case "cone":
                con = Connections.getConnection();

                // Display obj=new Display();
                OrderList.cancelOrder(Integer.parseInt(args[2]));
                Connections.disconnect(con);
                break;
            case "call":
                con = Connections.getConnection();

                // Display obj=new Display();
                OrderList.cancelOrder();
                Connections.disconnect(con);
                break;
            default:
                printHelp();

                break;
            }
            break;
        default:
            printHelp();
            break;
        }
    }
}