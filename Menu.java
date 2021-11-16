public class Menu {
    private int Food_Id;
    private String Food_Name;
    private String Category;
    private String Food_Type;
    private int Price;
    public Menu(int food_Id, String food_Name, String category, String food_Type, int price) {
        Food_Id = food_Id;
        Food_Name = food_Name;
        Category = category;
        Food_Type = food_Type;
        Price = price;
    }
    public Menu(String food_Name, String category, String food_Type, int price) {
        Food_Name = food_Name;
        Category = category;
        Food_Type = food_Type;
        Price = price;
    }
    public int getFood_Id() {
        return Food_Id;
    }
    public void setFood_Id(int food_Id) {
        Food_Id = food_Id;
    }
    public String getFood_Name() {
        return Food_Name;
    }
    public void setFood_Name(String food_Name) {
        Food_Name = food_Name;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public String getFood_Type() {
        return Food_Type;
    }
    public void setFood_Type(String food_Type) {
        Food_Type = food_Type;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        Price = price;
    }
}
