package Orders.item;

public class Item {
    private int Food_Id;
    private String Food_Name;
    private String Category;
    private String Food_Type;
    private int Price;
    private int quantity;
    private String date;

    public Item(int food_Id, String food_Name, String category, String food_Type, int price, int quantity,
            String date) {
        setFoodId(food_Id);
        setFoodName(food_Name);
        setCategory(category);
        setFoodType(food_Type);
        setPrice(price);
        setQuantity(quantity);
        setDate(date);
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String generateDate() {
        return ", Date=" + date.substring(0, 10) + "]";
    }

    @Override
    public String toString() {
        return "Item [Category=" + Category + ", Food_Id=" + Food_Id + ", Food_Name=" + Food_Name + ", Food_Type="
                + Food_Type + ", Price=" + Price + ", quantity=" + quantity;
    }

}
