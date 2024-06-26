/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

import java.sql.Date;

/**
 *
 * @author LÊ PHƯƠNG MAI
 */
public class Movies {

    private int movieID;
    private String title;
    private String description;
    private Date releaseDate;
    private String posterImage;
    private int duration;
    private int display;
    private String trailerURL;
    private String status;
    private String slug;
    public Movies() {
    }

    public Movies(int movieID, String title, String description, Date releaseDate, String posterImage, int duration, int display) {
        this.movieID = movieID;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.posterImage = posterImage;
        this.duration = duration;
        this.display = display;
    }

    public Movies(int movieID, String title) {
        this.movieID = movieID;
        this.title = title;
    }

    public Movies(int movieID, String title, String posterImage) {
        this.movieID = movieID;
        this.title = title;
        this.posterImage = posterImage;
    }

    public Movies(int movieID, String title, String description, Date releaseDate, String posterImage, int duration, int display, String trailerURL, String slug) {
        this.movieID = movieID;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.posterImage = posterImage;
        this.duration = duration;
        this.display = display;
        this.trailerURL = trailerURL;
        this.slug = slug;
    }
    
    
    
    

    public Movies(int movieID, String title, String description, Date releaseDate, String posterImage, int duration, int display, String trailerURL) {
        this.movieID = movieID;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.posterImage = posterImage;
        this.duration = duration;
        this.display = display;
        this.trailerURL = trailerURL;

    }

    
    

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    

}
