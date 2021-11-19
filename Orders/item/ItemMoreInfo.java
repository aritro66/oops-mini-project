package Orders.item;

public class ItemMoreInfo extends Item {

    public ItemMoreInfo(int food_Id, String food_Name, String category, String food_Type, int price, int quantity,
            String date) {
        super(food_Id, food_Name, category, food_Type, price, quantity, date);
        
    }
    @Override
    public String generateDate() {
        return ", Date="+getDate().substring(0, 10)+", Time="+getDate().substring(11) + "]";
    }
    

    @Override
    public String toString() {
        return "Item [Category=" + getCategory() + ", Food_Id=" + getFood_Id() + ", Food_Name=" + getFood_Id() + ", Food_Type="
        + getFood_Type() + ", Price=" + getPrice() + ", quantity=" + getQuantity();
    }
}
