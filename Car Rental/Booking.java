
import java.time.LocalDateTime;

public class Booking{
    private final String bookingId;
    private final User user;
    private final Car car;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final double totalCost;
    private BookingStatus status;

    public Booking(String bookingId, User user, Car car, LocalDateTime startTime, LocalDateTime endTime, double totalCost){
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = BookingStatus.CONFIRMED;
        this.totalCost = totalCost;
    }

    public String getBookingId(){
        return bookingId;
    }

    public User getUser(){
        return user;
    }

    public Car getCar(){
        return car;
    }

    public LocalDateTime getStartTime(){
        return startTime;
    }

    public LocalDateTime getEndTime(){
        return endTime;
    }

    public double getTotalCost(){
        return totalCost;
    }

    public BookingStatus getStatus(){
        return status;
    }

    public void setStatus(BookingStatus status){
        this.status = status;
    }
}