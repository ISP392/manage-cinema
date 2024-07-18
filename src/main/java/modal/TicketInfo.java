package modal;

import java.sql.Timestamp;

public class TicketInfo {
    private int ticketID;
    private String title;
    private Timestamp startTime;
    private Timestamp endTime;
    private String nameCinema;
    private String seatNumber;
    private String theaterNumber;
    private String priceTicket;

    public TicketInfo() {
    }

    public TicketInfo(int ticketID, String title, Timestamp startTime, Timestamp endTime, String nameCinema, String seatNumber, String theaterNumber, String priceTicket) {
        this.ticketID = ticketID;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.nameCinema = nameCinema;
        this.seatNumber = seatNumber;
        this.theaterNumber = theaterNumber;
        this.priceTicket = priceTicket;
    }

    // Getters and setters
    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getNameCinema() {
        return nameCinema;
    }

    public void setNameCinema(String nameCinema) {
        this.nameCinema = nameCinema;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(String priceTicket) {
        this.priceTicket = priceTicket;
    }

    public String getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(String theaterNumber) {
        this.theaterNumber = theaterNumber;
    }
    
}
