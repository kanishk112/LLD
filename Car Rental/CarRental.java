
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CarRental{
    private static CarRental instance;
    private final Map<String, Car> cars;
    private final Map<String, Booking> bookings;
    private final PaymentProcessor paymentProcessor;

    private CarRental(){
        cars = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardPayment();
    }

    public static synchronized CarRental getInstance(){
        if(instance == null){
            instance = new CarRental();
        }
        return instance;
    }

    public void addCar(Car car){
        cars.put(car.getCarId(), car);
    }

    public void removeCar(String carId){
        cars.remove(carId);
    }

    public List<Car> searchCar(String location, LocalDateTime startTime, LocalDateTime endTime){
        List<Car> availableCars = new ArrayList<>();
        for(Car car : cars.values()){
            if(car.getLocation().equals(location) && car.isAvailable()){
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public boolean isCarAvailable(Car car,LocalDateTime starTime, LocalDateTime endTime){
        if(!car.isAvailable()){
            return false;
        }
        for(Booking booking : bookings.values()){
            if(booking.getCar().getCarId().equals(car.getCarId())){
                if((starTime.isAfter(booking.getStartTime()) && starTime.isBefore(booking.getEndTime())) ||
                        (endTime.isAfter(booking.getStartTime()) && endTime.isBefore(booking.getEndTime()))){
                    return false;
                }
            }
        }
        return true;
    }

    public synchronized Booking bookCar(User user, Car car, LocalDateTime startTime, LocalDateTime endTime){
        if(isCarAvailable(car, startTime, endTime)){
            String bookingId = generateBookingId();
            Booking booking = new Booking(bookingId, user, car, startTime, endTime, car.getPricePerHour());
            bookings.put(bookingId, booking);
            car.setAvailable(false);
            return booking;
        }
        return null;
    }

    private String generateBookingId() {
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void cancelBooking(String bookingId){
        Booking booking = bookings.remove(bookingId);
        if(booking != null){
            booking.getCar().setAvailable(true);
            booking.setStatus(BookingStatus.CANCELLED);
        }
    }

    public boolean  processPayment(Booking booking){
        return paymentProcessor.processPayment(booking.getTotalCost());
    }
}