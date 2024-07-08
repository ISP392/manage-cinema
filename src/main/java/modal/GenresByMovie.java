package modal;

import java.io.StringBufferInputStream;

public class GenresByMovie {
    private int movieID;
    private String genreName;

    public GenresByMovie() {
    }

    public GenresByMovie(int movieID, String genreName) {
        this.movieID = movieID;
        this.genreName = genreName;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
