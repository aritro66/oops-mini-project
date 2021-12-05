package operation.display;

public class MenuDisplay {
    private int Food_Id;
    private String Food_Name;
    private String Category;
    private String Food_Type;
    private int Price;

    public MenuDisplay(int food_Id, String food_Name, String category, String food_Type, int price) {
        Food_Id = food_Id;
        Food_Name = food_Name;
        Category = category;
        Food_Type = food_Type;
        Price = price;
    }

    public int getFoodId() {
        return Food_Id;
    }

    public void setFoodId(int food_Id) {
        Food_Id = food_Id;
    }

    public String getFoodName() {
        return Food_Name;
    }

    public void setFoodName(String food_Name) {
        Food_Name = food_Name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getFoodType() {
        return Food_Type;
    }

    public void setFoodType(String food_Type) {
        Food_Type = food_Type;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    
}