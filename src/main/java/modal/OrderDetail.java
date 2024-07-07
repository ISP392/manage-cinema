/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.util.Map;

/**
 *
 * @author baoquoc
 */
public class OrderDetail {
    private ScreeningTimes screeningID;
    private String selectedSeats;
    private String totalPrice;
    private Map<FoodItem, Integer> foodMap;
    private Voucher voucherID;
    private int isVip;
    private int point;

    public OrderDetail() {
    }

    public OrderDetail(ScreeningTimes screeningID, String selectedSeats, String totalPrice) {
        this.screeningID = screeningID;
        this.selectedSeats = selectedSeats;
        this.totalPrice = totalPrice;
    }

    public ScreeningTimes getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(ScreeningTimes screeningID) {
        this.screeningID = screeningID;
    }

    public String getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(String selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<FoodItem, Integer> getFoodMap() {
        return foodMap;
    }

    public void setFoodMap(Map<FoodItem, Integer> foodMap) {
        this.foodMap = foodMap;
    }

    public Voucher getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Voucher voucherID) {
        this.voucherID = voucherID;
    }

    public int getIsVip() {
        return isVip;
    }

    public void setIsVip(int isVip) {
        this.isVip = isVip;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
