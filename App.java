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

    public static void printHelp(int page) {
        System.out.println("Help for commands:");
        String[] commands = { "-h", "-l", "-s all", "-s all \"Page No.\"", "-s cat \"CATEGORY\"",
                "-s cat \"CATEGORY\" \"Page No.\"", "-s type \"FOOD_TYPE\"",
                "-s type \"FOOD_TYPE\" \"Page No.\"", "-s fl cat \"CATEGORY\"", "-s fl cat \"CATEGORY\" \"Page No.\"",
                "-s fl foodname \"FOOD_NAME\"",
                "-s fl foodname \"FOOD_NAME\" \"Page No.\"", "-s ps cat \"CATEGORY\"",
                "-s ps cat \"CATEGORY\" \"Page No.\"",
                "-s ps foodname \"FOOD_NAME\"", "-s ps foodname \"FOOD_NAME\" \"Page No.\"", "-s range -e \"PRICE\"",
                "-s range -e \"PRICE\" \"Page No.\"",
                "-s range -g \"PRICE\"", "-s range -g \"PRICE\" \"Page No.\"",
                "-s range -ge \"PRICE\"", "-s range -ge \"PRICE\" \"Page No.\"", "-s range -l \"PRICE\"",
                "-s range -l \"PRICE\" \"Page No.\"",
                "-s range -le \"PRICE\"", "-s range -le \"PRICE\" \"Page No.\"",
                "-i \"Food_Name\" \"Category\" \"Food_Type\" \"Price\"", "-count cat", "-count veg", "-count nonveg",
                "-avg cat", "-avg veg", "-avg nonveg", "-u cat \"CATEGORY\" \"PRICE\"", "-u veg \"PRICE\"",
                "-u nonveg \"PRICE\"", "-u id \"FOOD_ID\" \"PRICE\"", "-u all \"PRICE\"", "-d \"FOOD_ID\"",
                "-o create \"FOOD_ID\" \"QUANTITY\"", "-o show", "-o showmore", "-o cone \"FOOD_ID\"", "-o call",
                "-v" };
        String[] description = { "Help for commands", "Load Menu.csv in MySql", "Display whole menu (Page 1)",
                "Display whole menu (Page No.)",
                "Display menu records for particular category (Page 1)",
                "Display menu records for particular category (Page No.)",
                "Display menu records for particular food type (Page 1)",
                "Display menu records for particular food type (Page No.)",
                "Display menu records for particular category (searching by first letters (Page 1))",
                "Display menu records for particular category (searching by first letters (Page No.))",
                "Display menu records for particular Food name (searching by first letters (Page 1))",
                "Display menu records for particular Food name (searching by first letters (Page No.))",
                "Display menu records for particular category (searching by Partial Strings (Page 1))",
                "Display menu records for particular category (searching by Partial Strings (Page No.))",
                "Display menu records for particular Food name (searching by Partial Strings (Page 1))",
                "Display menu records for particular Food name (searching by Partial Strings (Page No.))",
                "Display menu records for given price (Page 1)", "Display menu records for given price (Page No.)",
                "Display menu records for greater than given price (Page 1)",
                "Display menu records for greater than given price (Page No.)",
                "Display menu records for greater equal given price (Page 1)",
                "Display menu records for greater equal given price (Page No.)",
                "Display menu records for lesser than given price (Page 1)",
                "Display menu records for lesser than given price (Page No.)",
                "Display menu records for lesser equal given price (Page 1)",
                "Display menu records for lesser equal given price (Page No.)",
                "Insert new menu record with attribute Food_Name,Category,Food_Type,Price (Food Id is generated atomatically)",
                "count number of records in each category", "count number of records for veg food",
                "count number of records for nonveg food", "average number of records in each category",
                "average number of records for veg food", "average number of records for nonveg food",
                "update menu records price by category", "update menu records price of veg food",
                "update menu records price of nonveg food", "update menu record price for given food id",
                "update price of whole menu", "delete menu record by food id", "Place order with food id and quantity",
                "Show order list", "Show order list with more information", "Cancel particular order",
                "cancel whole order", "version" };
        String[] attributes = { "FOOD_ID", "FOOD_NAME", "CATEGORY", "FOOD_TYPE", "PRICE", "Page No." };
        String[] attributes_datatype = { "INTEGER", "STRING", "STRING", "STRING", "INTEGER", "INTEGER" };
        int pages = (int) Math.ceil(commands.length / 10.0);
        if(page<1||page>pages)
        {
            page=1;
        }
        for (int i = (page - 1) * 10; i < page * 10 && i < commands.length; i++) {
            System.out.printf("%-50s%s\n", commands[i], description[i]);

        }
        System.out.println(page + "/" + pages);
        System.out.println("\n\nData Type:");
        for (int i = 0; i < attributes_datatype.length; i++) {
            System.out.printf("%-20s%s\n", attributes[i], attributes_datatype[i]);
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
                    try {
                        if (args.length > 1) {
                            throw new Exception();
                        }
                        con = Connections.getConnection();
                        ImportData.loadData(con);
                        Connections.disconnect(con);
                    } catch (Exception e) {
                        System.out.println("Wrong command\nType \"-h\" to get help");
                    }

                    break;
                case "-s":
                    try {
                        switch (args[1]) {
                            case "all":
                                try {
                                    if (args.length == 2) {
                                        con = Connections.getConnection();
                                        Display.displayAll(con, 1);
                                        Connections.disconnect(con);
                                    } else if (args.length == 3) {
                                        con = Connections.getConnection();
                                        Display.displayAll(con, Integer.parseInt(args[2]));
                                        Connections.disconnect(con);
                                    } else if (args.length > 3) {
                                        throw new Exception();
                                    }

                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");
                                }

                                break;
                            case "cat":
                                try {
                                    if (args.length == 3) {
                                        con = Connections.getConnection();
                                        Display.displayCatagories(con, args[2], 1);
                                        Connections.disconnect(con);
                                    } else if (args.length == 4) {
                                        con = Connections.getConnection();
                                        Display.displayCatagories(con, args[2], Integer.parseInt(args[3]));
                                        Connections.disconnect(con);
                                    } else if (args.length > 4) {
                                        throw new Exception();
                                    }

                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");
                                }

                                break;
                            case "type":
                                try {
                                    if (args.length == 3) {
                                        con = Connections.getConnection();
                                        Display.displayType(con, args[2], 1);
                                        Connections.disconnect(con);
                                    } else if (args.length == 4) {
                                        con = Connections.getConnection();
                                        Display.displayType(con, args[2], Integer.parseInt(args[3]));
                                        Connections.disconnect(con);
                                    } else if (args.length > 4) {
                                        throw new Exception();
                                    }

                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");
                                }

                                break;
                            case "fl":
                                try {
                                    switch (args[2]) {
                                        case "cat":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayCatagoriesFirstLetter(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayCatagoriesFirstLetter(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }

                                            } catch (Exception e) {
                                                System.out.println("Wrong command\nType \"-h\" to get help");
                                            }

                                            break;
                                        case "foodname":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayFoodNameFirstLetter(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayFoodNameFirstLetter(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
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
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayCatagoriesPartialString(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayCatagoriesPartialString(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Wrong command\nType \"-h\" to get help");
                                            }

                                            break;
                                        case "foodname":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayFoodNamePartialString(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayFoodNamePartialString(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
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
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceEqual(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceEqual(con, args[3], Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Wrong command\nType \"-h\" to get help");

                                            }

                                            break;
                                        case "-g":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceGreater(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceGreater(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Wrong command\nType \"-h\" to get help");

                                            }

                                            break;
                                        case "-ge":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceGreaterEqual(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceGreaterEqual(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Wrong command\nType \"-h\" to get help");

                                            }

                                            break;
                                        case "-l":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceLesser(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceLesser(con, args[3], Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Wrong command\nType \"-h\" to get help");

                                            }

                                            break;
                                        case "-le":
                                            try {
                                                if (args.length == 4) {
                                                    con = Connections.getConnection();
                                                    Display.displayPriceLesserEqual(con, args[3], 1);
                                                    Connections.disconnect(con);
                                                } else if (args.length == 5) {
                                                    con = Connections.getConnection();
                                                    Display.displayCatagoriesFirstLetter(con, args[3],
                                                            Integer.parseInt(args[4]));
                                                    Connections.disconnect(con);
                                                } else if (args.length > 5) {
                                                    throw new Exception();
                                                }

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
                        if (args.length > 5) {
                            throw new Exception();
                        }
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
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    CountByCategory.count(con);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "veg":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    CountByVeg.count(con);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "nonveg":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    CountByNonVeg.count(con);
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
                case "-avg":
                    try {
                        switch (args[1]) {

                            case "cat":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    AvgByCategory.avg(con);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "veg":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    AvgByVeg.avg(con);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "nonveg":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    AvgByNonAvg.avg(con);
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
                case "-u":
                    try {
                        switch (args[1]) {

                            case "cat":
                                try {
                                    if (args.length > 4) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    Update.updateByCategory(con, args);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "veg":
                                try {
                                    if (args.length > 3) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    Update.updateByVeg(con, args);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "nonveg":
                                try {
                                    if (args.length > 3) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    Update.updateByNonVeg(con, args);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "id":
                                try {
                                    if (args.length > 4) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    Update.updateByFoodId(con, args);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "all":
                                try {
                                    if (args.length > 3) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    Update.updateAll(con, args);
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
                case "-o":
                    try {
                        switch (args[1]) {

                            case "create":
                                try {
                                    if (args.length > 4) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    OrderList.createOrder(con, args);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "show":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    OrderList.printOrder(con);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "showmore":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    OrderList.printOrderMore(con);
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "cone":
                                try {
                                    if (args.length > 3) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    OrderList.cancelOrder(con, Integer.parseInt(args[2]));
                                    Connections.disconnect(con);
                                } catch (Exception e) {
                                    System.out.println("Wrong command\nType \"-h\" to get help");

                                }

                                break;
                            case "call":
                                try {
                                    if (args.length > 2) {
                                        throw new Exception();
                                    }
                                    con = Connections.getConnection();
                                    OrderList.cancelOrder(con);
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
                case "-d":
                    try {
                        if (args.length > 2) {
                            throw new Exception();
                        }
                        con = Connections.getConnection();
                        Delete.deleteRecord(con, args);
                        Connections.disconnect(con);
                    } catch (Exception e) {
                        System.out.println("Wrong command\nType \"-h\" to get help");
                    }

                    break;
                case "-h":
                    try {
                        if (args.length == 1) {
                            printHelp(1);
                        }
                        else if(args.length == 2){
                            printHelp(Integer.parseInt(args[1]));
                        }
                        else if(args.length>2)
                        {
                            throw new Exception();
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Wrong command\nType \"-h\" to get help");

                    }

                    break;
                case "-v":
                    try {
                        if (args.length > 1) {
                            throw new Exception();
                        }
                        version();
                    } catch (Exception e) {
                        System.out.println("Wrong command\nType \"-h\" to get help");

                    }

                    break;
                default:
                    System.out.println("Wrong command\nType \"-h\" to get help");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Food Menu Management");
            System.out.println(
                    "This is a Command Line Record Maintenance Project. It is beneficial for both the client and the manager.\nThe client can easily search for food from the menu and also check his order history,\nand the manager can easily manipulate the food menu just by using commands.");
            System.out.println("Team Id - 1");
            System.out.println("Team members:");
            System.out.println(
                    "ARITRO GHOSH (S20200010021)\nPRANJAY GUPTA (S20200010169)\nSANJU SABU (S20200010187)\nGURRAM YASHASWI (S20200010073)\nMUDAVATH SUGALI ROHAN (S20200010037)");
            System.out.println("Type \"-h\" to get help");
            System.out.println("Type \"-v\" to get version");
        }

    }
}