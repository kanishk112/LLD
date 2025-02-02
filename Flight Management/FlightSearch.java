
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightSearch{
    private final List<Flight> flights;

    public FlightSearch(List<Flight> flights){
        this.flights = flights;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate date){
        List<Flight> result = new ArrayList<>();
        for(Flight flight: flights){
            if(flight.getSource().equals(source) && flight.getDestination().equals(destination) && flight.getDepartureTime().toLocalDate().equals(date)){
                result.add(flight);
            }
        }
        return result;
    }
}