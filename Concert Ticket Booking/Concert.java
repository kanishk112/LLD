
import java.time.LocalDateTime;
import java.util.List;

public class Concert{
    private final String concertId;
    private final String artist;
    private final String venue;
    private final LocalDateTime concertTime;
    private final List<Seat> seats;

    public Concert(String concertId, String artist, String venue, LocalDateTime concertTime, List<Seat> seats){
        this.concertId = concertId;
        this.artist = artist;
        this.venue = venue;
        this.concertTime = concertTime;
        this.seats = seats;
    }

    public String getConcertId(){
        return concertId;
    }

    public String getArtist(){
        return artist;
    }

    public String getVenue(){
        return venue;
    }

    public LocalDateTime getConcertTime(){
        return concertTime;
    }

    public List<Seat> getSeats(){
        return seats;
    }
}