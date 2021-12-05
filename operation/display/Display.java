package operation.display;

import java.sql.*;
import java.util.ArrayList;

public class Display {
  private static ArrayList<MenuDisplay> Lists = new ArrayList<>();

  public static void displayAll(Connection con, int page) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from menu");

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {

        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      
      System.out.println("Wrong command\nType \"-h\" to get help");
    }

  }

  public static void displayId(Connection con,int id) {
    try {
      String query = "select * from menu where Food_Id = ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, id);
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {

        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = 0; i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          

        
      }

    } catch (Exception e) {
      
      System.out.println("Wrong command\nType \"-h\" to get help");
    }

  }

  public static void displayCatagories(Connection con, String category,int page) {
    try {
      String query = "select * from menu where CATEGORY = ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, category);
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayCatagoriesFirstLetter(Connection con, String category,int page) {
    try {
      String query = "select * from menu where CATEGORY like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, category + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayFoodNameFirstLetter(Connection con, String foodname,int page) {
    try {
      String query = "select * from menu where FOOD_NAME like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, foodname + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayCatagoriesPartialString(Connection con, String category,int page) {
    try {
      String query = "select * from menu where CATEGORY like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, "%" + category + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayFoodNamePartialString(Connection con, String foodname,int page) {
    try {
      String query = "select * from menu where FOOD_NAME like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, "%" + foodname + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }
    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayType(Connection con, String type,int page) {
    try {
      String query = "select * from menu where FOOD_TYPE= ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, type);
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceGreater(Connection con, String price,int page) {
    try {
      String query = "select * from menu where PRICE > ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceGreaterEqual(Connection con, String price,int page) {
    try {
      String query = "select * from menu where PRICE >= ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceEqual(Connection con, String price,int page) {
    try {
      String query = "select * from menu where PRICE = ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceLesser(Connection con, String price,int page) {
    try {
      String query = "select * from menu where PRICE < ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceLesserEqual(Connection con, String price,int page) {
    try {
      String query = "select * from menu where PRICE <= ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        do {

          MenuDisplay I1 = new MenuDisplay(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
              rs.getInt(5));
          Lists.add(I1);
        } while (rs.next());

        int pages = (int) Math.ceil(Lists.size() / 10.0);
        if (page < 1 || page > pages) {
          System.out.println("Pages -> 1 to "+pages);
        } else {
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
              "Price");
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println();
          for (int i = (page - 1) * 10; i < page * 10 && i < Lists.size(); i++) {
            System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", Lists.get(i).getFoodId(),
                Lists.get(i).getFoodName(), Lists.get(i).getCategory(),
                Lists.get(i).getFoodType(), Lists.get(i).getPrice());
          }
          for (int i = 0; i < 121; i++) {
            System.out.print("-");
          }
          System.out.println("\nPage " + page + "/" + pages);

        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }
}
