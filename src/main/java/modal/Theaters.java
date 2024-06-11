/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author MISS NGA
 */
public class Theaters {
    private int theaterID;
    private Cinemas cinemaID;
    private int theaterNumber;
    private int totalSeats;

    public Theaters() {
    }

    public Theaters(int theaterID, Cinemas cinemaID, int theaterNumber, int totalSeats) {
        this.theaterID = theaterID;
        this.cinemaID = cinemaID;
        this.theaterNumber = theaterNumber;
        this.totalSeats = totalSeats;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public Cinemas getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(Cinemas cinemaID) {
        this.cinemaID = cinemaID;
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(int theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    
    
}
