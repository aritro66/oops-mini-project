import java.sql.*;
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
    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2", "root", "admin");
            // here sonoo is database name, root is username and password
            // Statement stmt = con.createStatement();
            // ResultSet rs = stmt.executeQuery("select * from emp");
            // System.out.println("Working");
            // while (rs.next())
            //     System.out.println( rs.getString(1) + "  " + rs.getString(1) + "  "+rs.getInt(3));
            
    }

    public static void disconnect() throws SQLException {
        con.close();
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
        Display obj = new Display();
        Insert obj2 = new Insert();
        CountByCategory obj3=new CountByCategory();
        CountByVeg obj4=new CountByVeg();
        CountByNonVeg obj5=new CountByNonVeg();
        Avg obj6=new Avg();



        System.out.println(args.length);

        switch (args[0]) {
        case "-d":
            switch (args[1]) {
            case "all":
                connect();
                obj.displayAll(con);
                disconnect();
                break;
            case "cat":
                connect();
                // Display obj=new Display();
                obj.displayCatagories(con);
                disconnect();
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-i":
            connect();
            obj2.insertRecord(con, args);
            disconnect();
            break;
        case "-count":
            switch (args[1]) {
            
            case "cat":
                connect();
                // Display obj=new Display();
                obj3.countCatagory(con);
                disconnect();
                break;
            case "veg":
                connect();
                // Display obj=new Display();
                obj4.countVeg(con);
                disconnect();
                break;
            case "nonveg":
                connect();
                // Display obj=new Display();
                obj5.countNonVeg(con);
                disconnect();
                break;
            default:
                printHelp();

                break;
            }
            break;
        case "-avg":
            connect();
            // Display obj=new Display();
            obj6.countAvg(con);
            disconnect();
        
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