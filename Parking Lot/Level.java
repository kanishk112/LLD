
import java.util.ArrayList;
import java.util.List;

public class Level{
    private  final int floorLevel;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floorLevel, int numOfSpots){
        this.floorLevel = floorLevel;
        parkingSpots = new ArrayList<>();
        
        double spotsForBikes = 0.30;
        double spotsForCars = 0.50;

        int numOfBikes = (int)(numOfSpots * spotsForBikes);
        int numOfCars = (int)(numOfSpots * spotsForCars);

        for(int i = 1; i <= numOfBikes; i++){
            parkingSpots.add(new ParkingSpot(i, vehicleType.BIKE));
        }
        
        for(int i = numOfBikes + 1; i <= numOfCars; i++){
            parkingSpots.add(new ParkingSpot(i, vehicleType.CAR));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)){
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailableSpots(){
        System.out.println("Floor Level: " + floorLevel+ " Available Spots:");
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable()){
                System.out.println(" Spot Number: " + spot.getSpotNumber() + " : "+(spot.isAvailable() ? "Available for " : "Occupied By ") + " " + spot.getVehicleType());
            }
        }
    }
}