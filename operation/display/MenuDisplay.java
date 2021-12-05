package operation.display;

public class MenuDisplay {
    private int foodId;
    private String foodName;
    private String category;
    private String foodType;
    private int price;
    public MenuDisplay(int foodId, String foodName, String category, String foodType, int price) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.category = category;
        this.foodType = foodType;
        this.price = price;
    }
    public int getFoodId() {
        return foodId;
    }
    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getFoodType() {
        return foodType;
    }
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

   

    
}