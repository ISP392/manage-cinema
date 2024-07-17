/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author caoha
 */
public class FoodItem {
    private int foodItemID;
    private String foodName;
    private String description;
    private int price;
    private String imgFoodItems;
    private int quantity;
    

    public FoodItem() {
    }

    public FoodItem(int foodItemID, String foodName, String description, int price, String imgFoodItems) {
        this.foodItemID = foodItemID;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.imgFoodItems = imgFoodItems;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgFoodItems() {
        return imgFoodItems;
    }

    public void setImgFoodItems(String imgFoodItems) {
        this.imgFoodItems = imgFoodItems;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
