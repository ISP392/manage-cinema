/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;


public class Review {
    private int reviewID;
    private int userID;
    private int movieID;
    private String comment;
    private int starRating;
    private String reviewDate;
    private Users user;

    public Review() {
    }

    public Review(int reviewID, int userID, int movieID, String comment, int starRating, String reviewDate) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.movieID = movieID;
        this.comment = comment;
        this.starRating = starRating;
        this.reviewDate = reviewDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getReviewID() {
        return reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getComment() {
        return comment;
    }

    public int getStarRating() {
        return starRating;
    }

    public String getReviewDate() {
        return reviewDate;
    }
    
}
