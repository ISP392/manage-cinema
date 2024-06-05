/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.time.LocalDateTime;


/**
 *
 * @author MISS NGA
 */
public class ScreeningTimes {
    private int screeningID;
    private Theaters theaterID;
    private Movies movieID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ScreeningTimes() {
    }

    public ScreeningTimes(int screeningID, Theaters theaterID, Movies movieID, LocalDateTime startTime, LocalDateTime endTime) {
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
  
}
