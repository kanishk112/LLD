
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingManager{
    private static BookingManager instance;
    private Map<String, Booking> bookings;
    private Object lock = new Object();
    private AtomicInteger bookingCounter = new AtomicInteger(0);

    private BookingManager(){
        bookings = new HashMap<>();
    }

    public static synchronized BookingManager getInstance(){
        if(instance == null){
            instance = new BookingManager();
        }
        return instance;
    }

    public Booking createBooking(Flight flight, Passenger passenger, Seat seat, double fare){
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, flight, passenger, seat, fare);
        synchronized(lock){
            bookings.put(bookingId, booking);
        }
        return booking;
    }

    public void cancelBooking(String bookingId){
        synchronized(lock){
            Booking booking = bookings.get(bookingId);
            if(booking != null){
                booking.cancelBooking();
            }
        }
    }

    public String generateBookingId(){
        int bookingId =  bookingCounter.incrementAndGet();
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "BKG" + timeStamp + String.format("%06d", bookingId);
    }
}