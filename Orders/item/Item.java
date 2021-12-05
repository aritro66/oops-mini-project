package Orders.item;

public class Item {
    private int foodId;
    private String foodName;
    private String category;
    private String foodType;
    private int price;
    private int quantity;
    private String date;

    public Item(int FoodId, String FoodName, String Category, String FoodType, int Price, int Quantity,
            String Date) {
        setFoodId(FoodId);
        setFoodName(FoodName);
        setCategory(Category);
        setFoodType(FoodType);
        setPrice(Price);
        setQuantity(Quantity);
        setDate(Date);
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int FoodId) {
        foodId = FoodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String FoodName) {
        foodName = FoodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String Category) {
        category = Category;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String FoodType) {
        foodType = FoodType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int Price) {
        price = Price;
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
        return "Item [FoodId=" + foodId + ", FoodName=" + foodName + ", Category=" + category + ", FoodType="
                + foodType + ", Price=" + price + ", quantity=" + quantity;
    }

}
