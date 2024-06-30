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
    private int rows;
    private int cols;

    public Theaters() {
    }

    public Theaters(int theaterID, Cinemas cinemaID, int theaterNumber) {
        this.theaterID = theaterID;
        this.cinemaID = cinemaID;
        this.theaterNumber = theaterNumber;
    }

    public Theaters(int theaterID, Cinemas cinemaID, int theaterNumber, int rows, int cols) {
        this.theaterID = theaterID;
        this.cinemaID = cinemaID;
        this.theaterNumber = theaterNumber;
        this.rows = rows;
        this.cols = cols;
    }
    


    public Theaters(int theaterID, Cinemas cinemaID) {
        this.theaterID = theaterID;
        this.cinemaID = cinemaID;
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
    
    
    
}
