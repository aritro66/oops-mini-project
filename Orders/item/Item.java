package Orders.item;

public class Item
{
    private int Food_Id;
    private String Food_Name;
    private String Category;
    private String Food_Type;
    private int Price;
    private int quantity;
    public Item(int food_Id, String food_Name, String category, String food_Type, int price, int quantity) {
        setFood_Id(food_Id);
        setFood_Name(food_Name);
        setCategory(category);
        setFood_Type(food_Type);
        setPrice(price);
        setQuantity(quantity);
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Item [Category=" + Category + ", Food_Id=" + Food_Id + ", Food_Name=" + Food_Name + ", Food_Type="
                + Food_Type + ", Price=" + Price + ", quantity=" + quantity + "]";
    }
    
    
    
}
