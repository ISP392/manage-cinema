package modal;

public class UserLikeMovie {
    private String userID;
    private int movieID;
    private int likeCount;

    public UserLikeMovie() {
    }

    public UserLikeMovie(String userID, int movieID, int likeCount) {
        this.userID = userID;
        this.movieID = movieID;
        this.likeCount = likeCount;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
