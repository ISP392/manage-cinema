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
public class Record {
    private String displayName;
    private Timestamp startTime;
    private Timestamp endTime;
    private int profit;
    private String name; 
    private int startAmount;
    private int endAmount;
    private int tranferPayment;

    public Record() {
    }
    public Record(String displayName, Timestamp startTime, Timestamp endTime, int profit, String name, int startAmount, int endAmount, int tranferPayment) {
        this.displayName = displayName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
        this.name = name;
        this.startAmount = startAmount;
        this.endAmount = endAmount;
        this.tranferPayment = tranferPayment;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(int startAmount) {
        this.startAmount = startAmount;
    }

    public int getEndAmount() {
        return endAmount;
    }

    public void setEndAmount(int endAmount) {
        this.endAmount = endAmount;
    }

    public int getTranferPayment() {
        return tranferPayment;
    }

    public void setTranferPayment(int tranferPayment) {
        this.tranferPayment = tranferPayment;
    }
    
}
