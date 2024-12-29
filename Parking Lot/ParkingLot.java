import java.util.ArrayList;
import java.util.List;

public class ParkingLot{
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot(){
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(){
        if(instance == null){
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle parked successfully");
                return true;
            }
        }
        System.out.println("Could not park vehicle");
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.unParkVehicle(vehicle)){
                System.out.println("Vehicle unparked successfully. The parking Spot is epmty now");
                return true;
            }
        }
        System.out.println("There is still a vehicle parked in the parking spot");
        return false;
    }

    public void displayAvailableSpots(){
        for(Level level : levels){
            level.displayAvailableSpots();
        }
    }

}