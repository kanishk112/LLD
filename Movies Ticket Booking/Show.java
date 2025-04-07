
import java.time.LocalDateTime;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Show {
    private final String showId;
    private final Movie movie;
    private final Theater theater;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final Map<String, Seat> seats;

    public Show(String showId, Movie movie, Theater theater, LocalDateTime startTime, LocalDateTime endTime, Map<String, Seat> seats){
        this.showId = showId;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = seats;
    }

    public String getId(){
        return showId;
    }

    public Movie getMovie(){
        return movie;
    }

    public Theater getTheater(){
        return theater;
    }

    public LocalDateTime getStarTime(){
        return startTime;
    }

    public LocalDateTime getEndTime(){
        return endTime;
    }

    public Map<String, Seat> getSeats(){
        return seats;
    }
}
