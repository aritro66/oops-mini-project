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
        String[] commands = { "-h", "-l", "-s all", "-s cat \"CATEGORY\"", "-s type \"FOOD_TYPE\"",
                "-s fl cat \"CATEGORY\"", "-s fl foodname \"FOOD_NAME\"", "-s ps cat \"CATEGORY\"",
                "-s ps foodname \"FOOD_NAME\"", "-s range -e \"PRICE\"", "-s range -g \"PRICE\"",
                "-s range -ge \"PRICE\"", "-s range -l \"PRICE\"", "-s range -le \"PRICE\"",
                "-i \"Food_Name\" \"Category\" \"Food_Type\" \"Price\"", "-count cat", "-count veg", "-count nonveg",
                "-avg cat", "-avg veg", "-avg nonveg", "-u cat \"CATEGORY\" \"PRICE\"", "-u veg \"PRICE\"",
                "-u nonveg \"PRICE\"", "-u id \"FOOD_ID\" \"PRICE\"", "-u all \"PRICE\"", "-d \"FOOD_ID\"",
                "-o create \"FOOD_ID\" \"QUANTITY\"", "-o show", "-o showmore", "-o cone \"FOOD_ID\"", "-o call",
                "-v" };
        String[] description = { "Help for commands", "Load Menu.csv in MySql", "Display whole menu",
                "Display menu records for particular category", "Display menu records for particular food type",
                "Display menu records for particular category (searching by first letters)",
                "Display menu records for particular Food name (searching by first letters)",
                "Display menu records for particular category (searching by Partial Strings)",
                "Display menu records for particular Food name (searching by Partial Strings)",
                "Display menu records for given price", "Display menu records for greater than given price",
                "Display menu records for greater equal given price",
                "Display menu records for lesser than given price", "Display menu records for lesser equal given price",
                "Insert new menu record with attribute Food_Name,Category,Food_Type,Price (Food Id is generated atomatically)",
                "count number of records in each category", "count number of records for veg food",
                "count number of records for nonveg food", "average number of records in each category",
                "average number of records for veg food", "average number of records for nonveg food",
                "update menu records price by category", "update menu records price of veg food",
                "update menu records price of nonveg food", "update menu record price for given food id",
                "update price of whole menu", "delete menu record by food id", "Place order with food id and quantity",
                "Show order list", "Show order list with more information", "Cancel particular order",
                "cancel whole order", "version" };

        for (int i = 0; i < commands.length; i++) {
            System.out.printf("%-50s%s\n", commands[i], description[i]);

        }

    }

    public static void version() {
        System.out.println("Version \"1.0.0\"");
        System.out.println("Used for the project ->");
        System.out.println("java version \"16.0.2\"");
        System.out.println("mysql-connector-java \"8.0.27\"");

    }

    public static void main(String[] args) {

        try {
            switch (args[0]) {
            case "-l":
                con = Connections.getConnection();
                ImportData.loadData(con);
                Connections.disconnect(con);
                break;
            case "-s":
                try {
                    switch (args[1]) {
                    case "all":
                        con = Connections.getConnection();
                        Display.displayAll(con);
                        Connections.disconnect(con);
                        break;
                    case "cat":
                        try {
                            con = Connections.getConnection();
                            Display.displayCatagories(con, args[2]);
                            Connections.disconnect(con);
                        } catch (Exception e) {
                            System.out.println("Wrong command\nType \"-h\" to get help");
                        }

                        break;
                    case "type":
                        try {
                            con = Connections.getConnection();
                            Display.displayType(con, args[2]);
                            Connections.disconnect(con);
                        } catch (Exception e) {
                            System.out.println("Wrong command\nType \"-h\" to get help");
                        }

                        break;
                    case "fl":
                        try {
                            switch (args[2]) {
                            case "cat":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayCatagoriesFirstLetter(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");
                                }

                                break;
                            case "foodname":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayFoodNameFirstLetter(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");
                                }

                                break;

                            default:
                                System.out.println("Wrong command\nType \"-h\" to get help");
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Wrong command\nType \"-h\" to get help");
                        }
                        break;

                    case "ps":
                        try {
                            switch (args[2]) {
                            case "cat":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayCatagoriesPartialString(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");
                                }

                                break;
                            case "foodname":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayFoodNamePartialString(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;

                            default:
                                System.out.println("Wrong command\nType \"-h\" to get help");
                                break;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong command\nType \"-h\" to get help");
                        }
                        break;

                    case "range":
                        try {
                            switch (args[2]) {
                            case "-e":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayPriceEqual(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "-g":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayPriceGreater(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "-ge":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayPriceGreaterEqual(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "-l":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayPriceLesser(con, args[3]);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "-le":
                                try {
                                    con = Connections.getConnection();
                                    Display.displayPriceLesserEqual(con, args[3]);
                                    Connections.disconnect(con);

                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            default:
                                System.out.println("Wrong command\nType \"-h\" to get help");
                                break;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Wrong command\nType \"-h\" to get help");

                        }
                        break;
                    default:
                        System.out.println("Wrong command\nType \"-h\" to get help");

                        break;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");
                }
                break;
            case "-i":
                try {
                    con = Connections.getConnection();
                    Insert.insertRecord(con, args);
                    Connections.disconnect(con);
                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");

                }

                break;
            case "-count":
                try {
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
                        System.out.println("Wrong command\nType \"-h\" to get help");

                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");
                }

                break;
            case "-avg":
                try {
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
                        System.out.println("Wrong command\nType \"-h\" to get help");

                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");
                }

                break;
            case "-u":
                try {
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
                        System.out.println("Wrong command\nType \"-h\" to get help");

                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");

                }

                break;
            case "-o":
                try {
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
                        try {
                            con = Connections.getConnection();

                            OrderList.cancelOrder(con, Integer.parseInt(args[2]));
                            Connections.disconnect(con);
                        } catch (Exception e) {
                            System.out.println("Wrong command\nType \"-h\" to get help");

                        }

                        break;
                    case "call":
                        con = Connections.getConnection();

                        OrderList.cancelOrder(con);
                        Connections.disconnect(con);
                        break;
                    default:
                        System.out.println("Wrong command\nType \"-h\" to get help");

                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");

                }

                break;
            case "-d":
                try {
                    con = Connections.getConnection();
                    Delete.deleteRecord(con, args);
                    Connections.disconnect(con);
                } catch (Exception e) {
                    System.out.println("Wrong command\nType \"-h\" to get help");
                }

                break;
            case "-h":
                printHelp();
                break;
            case "-v":
                version();
                break;
            default:
                System.out.println("Wrong command\nType \"-h\" to get help");
                break;
            }
        } catch (Exception e) {
            System.out.println("Wrong command\nType \"-h\" to get help");
        }

    }
}