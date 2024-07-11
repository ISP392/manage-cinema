/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author MISS NGA
 */
public class OrderFoodItems {
    private String id;
    private Orders orderID;
    private FoodItem foodItemID;
    private int quantity;

    public OrderFoodItems() {
    }

    public OrderFoodItems(String id, Orders orderID, FoodItem foodItemID, int quantity) {
        this.id = id;
        this.orderID = orderID;
        this.foodItemID = foodItemID;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

    public FoodItem getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(FoodItem foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
