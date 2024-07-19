/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.sql.Timestamp;

/**
 *
 * @author baoquoc
 */
public class ShiftCurrent {
    private int shiftID;
    private Users phone;
    private Timestamp startTime;
    private Timestamp endTime;
    private double startAmount;
    private double endAmount;

    public ShiftCurrent() {
    }

    public ShiftCurrent(int shiftID, Users phone, Timestamp startTime, Timestamp endTime, double startAmount, double endAmount) {
        this.shiftID = shiftID;
        this.phone = phone;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startAmount = startAmount;
        this.endAmount = endAmount;
    }

    public ShiftCurrent(Timestamp startTime, Users phone){
        this.startTime = startTime;
        this.phone = phone;
    }

    public int getShiftID() {
        return shiftID;
    }

    public void setShiftID(int shiftID) {
        this.shiftID = shiftID;
    }

    public Users getPhone() {
        return phone;
    }

    public void setPhone(Users phone) {
        this.phone = phone;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public double getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(double endAmount) {
        this.endAmount = endAmount;
    }
    
    
}
