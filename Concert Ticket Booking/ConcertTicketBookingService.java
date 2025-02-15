
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcertTicketBookingService{
    private static ConcertTicketBookingService instance;
    private final Map<String, Concert> concerts;
    private final Map<String, Booking> bookings;
    private final Object lock = new Object();

    private ConcertTicketBookingService(){
        concerts = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }

    public static synchronized ConcertTicketBookingService getInstance(){
        if(instance == null){
            instance = new ConcertTicketBookingService();
        }
        return instance;
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getConcertId(), concert);
    }

    public Concert getConcert(String concertId){
        return concerts.get(concertId);
    }

    public List<Concert> searchConcerts(String artist, String venue, LocalDateTime dateTime) {
        return concerts.values().stream()
                .filter(concert -> concert.getArtist().equalsIgnoreCase(artist) &&
                        concert.getVenue().equalsIgnoreCase(venue) &&
                        concert.getConcertTime().equals(dateTime))
                .collect(Collectors.toList());
    }

    public Booking bookTickets(User user, Concert concert, List<Seat> seats){
        synchronized (lock) {
            for(Seat seat: seats){
                if(seat.getSeatStatus() != SeatStatus.AVAILABLE){
                    throw new SeatNotAvailableException("Seat "+ seat.getSeatNumber()+ " is not available");
                }
            }
            seats.forEach(Seat::seatBooking);

            String bookingId = generateBookingId();
            Booking booking = new Booking(bookingId, user, concert, seats);
            bookings.put(bookingId, booking);

            processPayment(booking);
            booking.confirmBooking();
            System.out.println("Booking "+booking.getBookingId()+ "-"+booking.getSeats().size()+ "seats booked");
            return booking;
        }
    }

    public void cancelBooking(String bookingId){
        Booking booking = bookings.get(bookingId);
        if(booking != null){
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
    }

    private void processPayment(Booking booking){
        System.out.println("Processing payment. Please wait!!");
    }

    private String generateBookingId(){
        return "BKG"+ UUID.randomUUID();
    }
}