public class Booking{
    private final String bookingId;
    private final Flight flight;
    private final Passenger passenger;
    private final Seat seat;
    private BookingStatus status;
    private final double fare;

    public Booking(String bookingId, Flight flight, Passenger passenger, Seat seat, double fare){
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.status = BookingStatus.CONFIRMED;
        this.fare = fare;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void cancelBooking(){
        status = BookingStatus.CANCELLED;
    }
}