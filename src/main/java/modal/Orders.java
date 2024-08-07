/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.util.List;

/**
 *
 * @author MISS NGA
 */
public class Orders {
    private int orderID;
    private Users userID;
    private Movies movieID;
    private int quantity;
    private String allPrice;
    List<OrderFoodItem> orderFood;
    private TicketInfo ticketInfo;
    private int staffID;

    public Orders() {
    }

    public Orders(int orderID, Users userID, Movies movieID, int quantity, String allPrice) {
        this.orderID = orderID;
        this.userID = userID;
        this.movieID = movieID;
        this.quantity = quantity;
        this.allPrice = allPrice;
    }

    public Orders(int orderID, Users userID, Movies movieID, int quantity, String allPrice, List<OrderFoodItem> orderFood, TicketInfo ticketInfo, int staffID) {
        this.orderID = orderID;
        this.userID = userID;
        this.movieID = movieID;
        this.quantity = quantity;
        this.allPrice = allPrice;
        this.orderFood = orderFood;
        this.ticketInfo = ticketInfo;
        this.staffID = staffID;
    }
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Movies getMovieID() {
        return movieID;
    }

    public void setMovieID(Movies movieID) {
        this.movieID = movieID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public List<OrderFoodItem> getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(List<OrderFoodItem> orderFood) {
        this.orderFood = orderFood;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    
    
}
