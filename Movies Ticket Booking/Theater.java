
import java.util.List;

public class Theater{
    private final String theaterId;
    private final String name;
    private final String location;
    private final List<Show> shows;

    public Theater(String theaterId, String name, String location, List<Show> shows){
        this.theaterId = theaterId;
        this.name = name;
        this.location = location;
        this.shows = shows;
    }
}