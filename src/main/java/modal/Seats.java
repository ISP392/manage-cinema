/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author MISS NGA
 */
public class Seats {
    private int seatID;
    private ScreeningTimes screeningID;
    private String seatNumber;
    private String seatStatus;

    public Seats() {
    }

    public Seats(int seatID, ScreeningTimes screeningID, String seatNumber, String seatStatus) {
        this.seatID = seatID;
        this.screeningID = screeningID;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    public Seats(int seatID, String seatNumber, ScreeningTimes screeningID){
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.screeningID = screeningID;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public ScreeningTimes getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(ScreeningTimes screeningID) {
        this.screeningID = screeningID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
    
    
}
