/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 * @author ACER
 */
public class RecruimentCinemas {
    private int cinemaId;
    private int recruimentId;
    private Cinemas cinema;

    public RecruimentCinemas() {
    }

    public RecruimentCinemas(int cinemaId, int recruimentId, Cinemas cinema) {
        this.cinemaId = cinemaId;
        this.recruimentId = recruimentId;
        this.cinema = cinema;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getRecruimentId() {
        return recruimentId;
    }

    public void setRecruimentId(int recruimentId) {
        this.recruimentId = recruimentId;
    }

    public Cinemas getCinema() {
        return cinema;
    }

    public void setCinema(Cinemas cinema) {
        this.cinema = cinema;
    }
    
    
}
