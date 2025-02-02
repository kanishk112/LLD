
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main{
    public static void main(String args[]){
        AirlineManagement airlineManagement = new AirlineManagement();

        Passenger passenger1 = new Passenger("P001", "Ram", "ram@x.com", "+91112");

        LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1 = departureTime1.plusHours(2);

        Flight flight1 = new Flight("F001", "Delhi", "Jaipur", departureTime1, arrivalTime1);

        LocalDateTime departureTime2 = LocalDateTime.now().plusDays(3);
        LocalDateTime arrivalTime2 = departureTime1.plusHours(5);

        Flight flight2 = new Flight("F002", "Mumbai", "Goa", departureTime2, arrivalTime2);

        airlineManagement.addFlight(flight1);
        airlineManagement.addFlight(flight2);

        Aircraft aircraft1 = new Aircraft("A001", "Boeing 747", 270);
        Aircraft aircraft2 = new Aircraft("A002", "Boeing 707", 320);

        airlineManagement.addAircraft(aircraft1);
        airlineManagement.addAircraft(aircraft2);

        List<Flight> searchResults = airlineManagement.searchFlights("Delhi", "Jaipur", LocalDate.now().plusDays(1));
        System.out.println("Search results--");
        for(Flight flight : searchResults){
            System.out.println("Flight: "+ flight.getFlightNumber()+ " - "+ flight.getSource()+ " to "+ flight.getDestination());
        }

        Seat seat = new Seat("23A", SeatClass.ECONOMY);

        Booking booking  = airlineManagement.bookFLight(flight1, passenger1, seat, 100);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
        } else {
            System.out.println("Booking failed.");
        }

        // Cancel a booking
        airlineManagement.cancelBooking(booking.getBookingId());
        System.out.println("Booking cancelled.");
    }
}