public class Car{
    private final String carId;
    private final String model;
    private final String location;
    private boolean isAvailable;
    private final double pricePerHour;

    public Car(String carId, String model, String location, double pricePerHour){
        this.carId = carId;
        this.model = model;
        this.location = location;
        this.pricePerHour = pricePerHour;
        this.isAvailable = true;
    }

    public String getCarId(){
        return carId;
    }

    public String getModel(){
        return model;
    }

    public String getLocation(){
        return location;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public double getPricePerHour(){
        return pricePerHour;
    }

    public void display(){
        System.out.println("Car ID: " + carId);
        System.out.println("Model: " + model);
        System.out.println("Location: " + location);
        System.out.println("Price per hour: " + pricePerHour);
        System.out.println("Available: " + isAvailable);
    }
}