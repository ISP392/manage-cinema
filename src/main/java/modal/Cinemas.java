/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.sql.Date;

/**
 *
 * @author MISS NGA
 */
public class Cinemas {
    private int cinemaID;
    private String name;
    private Date movieDate;
    private Location locationID;

    public Cinemas() {
    }

    public Cinemas(int cinemaID, String name, Date movieDate, Location locationID) {
        this.cinemaID = cinemaID;
        this.name = name;
        this.movieDate = movieDate;
        this.locationID = locationID;
    }

    public Cinemas(String name, Location locationID) {
        this.name = name;
        this.locationID = locationID;
    }

    public Cinemas(String name, Date movieDate) {
        this.name = name;
        this.movieDate = movieDate;
    }
    
    

    public Cinemas(String name) {
        this.name = name;
    }
    
    

    public int getCinemaID() {
        return cinemaID;
    }

    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }
}
