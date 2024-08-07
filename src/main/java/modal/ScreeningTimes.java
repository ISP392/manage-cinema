/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author MISS NGA
 */
public class ScreeningTimes {

    private int screeningID;
    private int theaterId;
    private int movieId;
    private Theaters theaterID;
    private Movies movieID;
    private Timestamp startTime;
    private Timestamp endTime;

    public ScreeningTimes() {
    }

    public int getTheaterId() {
        return theaterId;
    }

    public ScreeningTimes(Theaters theaterID, Movies movieID, Timestamp startTime, Timestamp endTime) {
        this.theaterID = theaterID;
        this.movieID = movieID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "ScreeningTimes{" + "screeningID=" + screeningID + ", theaterID=" + theaterId + ", movieID=" + movieId + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }

    public ScreeningTimes(int screeningID, int theaterId, int movieId, Timestamp startTime, Timestamp endTime) {
        this.screeningID = screeningID;
        this.theaterId = theaterId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ScreeningTimes(int screeningID, Theaters theaterID, Movies movieID, Timestamp startTime, Timestamp endTime) {
        this.screeningID = screeningID;
        this.theaterID = theaterID;
        this.movieID = movieID;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ScreeningTimes(int screeningID, Movies movieID, Timestamp startTime, Timestamp endTime, Theaters theaterID) {
        this.screeningID = screeningID;
        this.movieID = movieID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.theaterID = theaterID;
    }

    public ScreeningTimes(Theaters theaterID, Timestamp startTimes, Timestamp endTime) {
        this.theaterID = theaterID;
        this.startTime = startTimes;
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

}
