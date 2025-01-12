
import java.time.LocalDateTime;
import java.util.List;

public class Main{
    public static void main(String[] args){
        CarRental carRental = CarRental.getInstance();
        Car car1 = new Car("1", "Toyota", "New York", 100);
        Car car2 = new Car("2", "Honda", "New York", 120);
        carRental.addCar(car1);
        carRental.addCar(car2);

        User user1 = new User("1", "John", "john@example.com");

        carRental.searchCar("New York", LocalDateTime.now(), LocalDateTime.now().plusHours(2)).forEach(Car::display);
        carRental.removeCar("1");
        carRental.searchCar("New York", LocalDateTime.now(), LocalDateTime.now().plusHours(2)).forEach(Car::display);

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(3);
        List<Car> availableCars = carRental.searchCar("NewYork", startTime, endTime);
        if (!availableCars.isEmpty()) {
            Car selectedCar = availableCars.getFirst();
            Booking booking = carRental.bookCar(user1, selectedCar, startTime, endTime);
            if (booking != null) {
                boolean paymentSuccess = carRental.processPayment(booking);
                if (paymentSuccess) {
                    System.out.println("Booking successful. Booking ID: " + booking.getBookingId());
                } else {
                    System.out.println("Payment failed. Booking canceled.");
                    carRental.cancelBooking(booking.getBookingId());
                }
            } else {
                System.out.println("Selected car is not available for the given dates.");
            }
        } else {
            System.out.println("No available cars found for the given criteria.");
        }
    }
}