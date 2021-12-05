package Orders.item;

public class ItemMoreInfo extends Item {

    public ItemMoreInfo(int foodId, String foodName, String category, String foodType, int price, int quantity,
            String date) {
        super(foodId, foodName, category, foodType, price, quantity, date);

    }

    @Override
    public String generateDate() {
        return ", Date=" + getDate().substring(0, 10) + ", Time=" + getDate().substring(11) + "]";
    }

    @Override
    public String toString() {
        return "Item [FoodId=" + getFoodId() + ", FoodName=" + getFoodName()+", Category=" + getCategory() 
                + ", FoodType=" + getFoodType() + ", Price=" + getPrice() + ", quantity=" + getQuantity();
    }
}
