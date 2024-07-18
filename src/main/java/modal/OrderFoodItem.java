/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modal;

import java.util.List;

/**
 *
 * @author HP
 */
public class OrderFoodItem {
    private int id;
    private int orderID;
    private int foodItemID;
    private int quantity;
    private FoodItem foods;

    public OrderFoodItem() {}

    public OrderFoodItem(int id, int orderID, int foodItemID, int quantity) {
        this.id = id;
        this.orderID = orderID;
        this.foodItemID = foodItemID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getFoodItemID() {
        return foodItemID;
    }

    public void setFoodItemID(int foodItemID) {
        this.foodItemID = foodItemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public FoodItem getFoods() {
        return foods;
    }

    public void setFoods(FoodItem foods) {
        this.foods = foods;
    }
}
