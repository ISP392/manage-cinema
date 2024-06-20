/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class Voucher {
    private int voucherID;
    private String voucherName;
    private String voucherDescription;
    private int discountAmount;
    private Date startDate;
    private Date endDate;
    private int quantity;

    public Voucher() {
    }

    public Voucher(int voucherID, String voucherName, String voucherDescription, int discountAmount, Date startDate, Date endDate, int quantity) {
        this.voucherID = voucherID;
        this.voucherName = voucherName;
        this.voucherDescription = voucherDescription;
        this.discountAmount = discountAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.quantity = quantity;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    public String getVoucherDescription() {
        return voucherDescription;
    }

    public void setVoucherDescription(String voucherDescription) {
        this.voucherDescription = voucherDescription;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
