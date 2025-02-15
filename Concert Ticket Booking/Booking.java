
import java.util.List;

public class Booking{
    private final String bookingId;
    private final User user;
    private final Concert concert;
    private final List<Seat> seats;
    private final double price;
    private BookingStatus bookingStatus;

    public Booking(String bookingId, User user, Concert concert, List<Seat> seat){
        this.bookingId = bookingId;
        this.user = user;
        this.concert = concert;
        this.seats = seat;
        this.bookingStatus = BookingStatus.PENDING;
        this.price = calculateTotalPrice();
    }

    private double calculateTotalPrice(){
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }

    public void confirmBooking(){
        if(bookingStatus == BookingStatus.PENDING){
            bookingStatus = BookingStatus.CONFIRMED;
        }
    }
    
    public void cancelBooking(){
        if(bookingStatus == BookingStatus.CONFIRMED){
            bookingStatus = BookingStatus.CANCELLED;
            seats.forEach(Seat::seatRelease);
            System.out.printf("Booking %s cancelled\n", bookingId);
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Concert getConcert() {
        return concert;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getTotalPrice() {
        return price;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}