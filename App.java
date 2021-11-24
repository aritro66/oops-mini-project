import java.sql.*;
import connection.*;
import load.*;
import Orders.order.*;
import operation.update.*;
import operation.display.*;
import operation.insert.*;
import operation.delete.*;
import stats.count.*;
import stats.avg.*;

public class App {

    public static Connection con = null;

    

    

    public static void printHelp() {
        System.out.println("Help for commands:");
        String[] commands={"-h","-l","-s all","-s cat \"CATEGORY\"","-s type \"FOOD_TYPE\"","-s fl cat \"CATEGORY\"","-s fl foodname \"FOOD_NAME\"","-s ps cat \"CATEGORY\"","-s ps foodname \"FOOD_NAME\"","-s range -e \"PRICE\"","-s range -g \"PRICE\"","-s range -ge \"PRICE\"","-s range -l \"PRICE\"","-s range -le \"PRICE\"","-i \"Food_Name\" \"Category\" \"Food_Type\" \"Price\"","-count cat","-count veg","-count nonveg","-avg cat","-avg veg","-avg nonveg","-u cat \"CATEGORY\" \"PRICE\"","-u veg \"PRICE\"","-u nonveg \"PRICE\"","-u id \"FOOD_ID\" \"PRICE\"","-u all \"PRICE\"","-d \"FOOD_ID\"","-o create \"FOOD_ID\" \"QUANTITY\"","-o show","-o showmore","-o cone \"FOOD_ID\"","-o call"};
        String[] description={"Help for commands","Load Menu.csv in MySql","Display whole menu","Display menu records for particular category","Display menu records for particular food type","Display menu records for particular category (searching by first letters)","Display menu records for particular Food name (searching by first letters)","Display menu records for particular category (searching by Partial Strings)","Display menu records for particular Food name (searching by Partial Strings)","Display menu records for given price","Display menu records for greater than given price","Display menu records for greater equal given price","Display menu records for lesser than given price","Display menu records for lesser equal given price","Insert new menu record with attribute Food_Name,Category,Food_Type,Price (Food Id is generated atomatically)","count number of records in each category","count number of records for veg food","count number of records for nonveg food","average number of records in each category","average number of records for veg food","average number of records for nonveg food","update menu records price by category","update menu records price of veg food","update menu records price of nonveg food","update menu record price for given food id","update price of whole menu","delete menu record by food id","Place order with food id and quantity","Show order list","Show order list with more information","Cancel particular order","cancel whole order"};
        
        for(int i=0;i<commands.length;i++)
        {
            System.out.printf("%-50s%s\n", commands[i],description[i]);
                
        }
        
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        

        System.out.println(args.length);
        
        switch (args[0]) {
        case "-l":
            con=Connections.getConnection();
            ImportData.loadData(con);
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
            case "fl":
                switch (args[2]) {
                    case "cat":
                    con = Connections.getConnection();
                    Display.displayCatagoriesFirstLetter(con, args[3]);
                    Connections.disconnect(con);
                    break;
                    case "foodname":
                    con = Connections.getConnection();
                    Display.displayFoodNameFirstLetter(con, args[3]);
                    Connections.disconnect(con);
                    break;
                
                    default:
                    printHelp();
                        break;
                }
                case "ps":
                switch (args[2]) {
                    case "cat":
                    con = Connections.getConnection();
                    Display.displayCatagoriesPartialString(con, args[3]);
                    Connections.disconnect(con);
                    break;
                    case "foodname":
                    con = Connections.getConnection();
                    Display.displayFoodNamePartialString(con, args[3]);
                    Connections.disconnect(con);
                    break;
                
                    default:
                    printHelp();
                        break;
                }
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
                printHelp();
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
            case "showmore":
                con = Connections.getConnection();

                OrderList.printOrderMore(con);
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