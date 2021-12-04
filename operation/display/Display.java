package operation.display;

import java.sql.*;

public class Display {
  public static void displayAll(Connection con) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from menu");

      if (rs.next() == false) {
        System.out.println("No Result");
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
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.println();

      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");
    }

  }

  public static void displayCatagories(Connection con, String category) {
    try {
      String query = "select * from menu where CATEGORY = ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, category);
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayCatagoriesFirstLetter(Connection con, String category) {
    try {
      String query = "select * from menu where CATEGORY like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, category + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayFoodNameFirstLetter(Connection con, String foodname) {
    try {
      String query = "select * from menu where FOOD_NAME like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, foodname + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayCatagoriesPartialString(Connection con, String category) {
    try {
      String query = "select * from menu where CATEGORY like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, "%" + category + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayFoodNamePartialString(Connection con, String foodname) {
    try {
      String query = "select * from menu where FOOD_NAME like ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, "%" + foodname + "%");
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }
    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayType(Connection con, String type) {
    try {
      String query = "select * from menu where FOOD_TYPE= ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString(1, type);
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceGreater(Connection con, String price) {
    try {
      String query = "select * from menu where PRICE > ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceGreaterEqual(Connection con, String price) {
    try {
      String query = "select * from menu where PRICE >= ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceEqual(Connection con, String price) {
    try {
      String query = "select * from menu where PRICE = ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceLesser(Connection con, String price) {
    try {
      String query = "select * from menu where PRICE < ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }

  public static void displayPriceLesserEqual(Connection con, String price) {
    try {
      String query = "select * from menu where PRICE <= ? ";
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setInt(1, Integer.parseInt(price));
      ResultSet rs = preparedStmt.executeQuery();

      if (rs.next() == false) {
        System.out.println("No Result");
      } else {
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", "Food_Id", "Food_Name", "Category", "Food_Type",
            "Price");
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
        do {
          System.out.printf("| %-10s| %-35s| %-25s| %-25s| %-15s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
              rs.getString(4), rs.getInt(5));
        } while (rs.next());
        for (int i = 0; i < 121; i++) {
          System.out.print("-");
        }
      }

    } catch (Exception e) {
      System.out.println("Wrong command\nType \"-h\" to get help");

    }

  }
}
