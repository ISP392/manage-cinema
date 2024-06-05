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
public class ScreeningTimes {
    private int screeningID;
    private Theaters theaterID;
    private Movies movieID;
    private Date startTime;
    private Date endTime;

    public ScreeningTimes() {
    }

    public ScreeningTimes(int screeningID, Theaters theaterID, Movies movieID, Date startTime, Date endTime) {
        this.screeningID = screeningID;
        this.theaterID = theaterID;
        this.movieID = movieID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public Theaters getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(Theaters theaterID) {
        this.theaterID = theaterID;
    }

    public Movies getMovieID() {
        return movieID;
    }

    public void setMovieID(Movies movieID) {
        this.movieID = movieID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    
}
