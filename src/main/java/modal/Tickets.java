package modal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Tickets class
 *
 * @autor MISS NGA
 */
public class Tickets {

    private int ticketID;
    private Users userID;
    private Movies movieID;
    private Cinemas cinemaID;
    private String price;
    private Timestamp purchaseDate;
    private Seats seatID;
    private Orders orderID;
    private List<Seats> seats;
    private List<Integer> ticketIDs;

    public Tickets(int ticketID, Users userID, Movies movieID, Cinemas cinemaID, String price, Timestamp purchaseDate, Seats seatID, Orders orderID) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.movieID = movieID;
        this.cinemaID = cinemaID;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.seatID = seatID;
        this.orderID = orderID;
        this.seats = new ArrayList<>();
        this.ticketIDs = new ArrayList<>();
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
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

    public Cinemas getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(Cinemas cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Seats getSeatID() {
        return seatID;
    }

    public void setSeatID(Seats seatID) {
        this.seatID = seatID;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    public List<Integer> getTicketIDs() {
        return ticketIDs;
    }

    public void setTicketIDs(List<Integer> ticketIDs) {
        this.ticketIDs = ticketIDs;
    }
    @Override
    public String toString() {
        return "Tickets{" + "ticketID=" + ticketID + ", userID=" + userID + ", movieID=" + movieID + ", cinemaID=" + cinemaID + ", price=" + price + ", purchaseDate=" + purchaseDate + ", seatID=" + seatID + ", orderID=" + orderID + '}';
    }

    
    
}
