public class Main{
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();
        
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 10));

        Car car1 = new Car("KA01HH1234");
        Car car2 = new Car("KA01HH1235");
        
        Bike bike1 = new Bike("KA01HH1236");
        Bike bike2 = new Bike("KA01HH1237");
        
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);
        parkingLot.parkVehicle(car1);
        
        parkingLot.displayAvailableSpots();

        parkingLot.unParkVehicle(car1);
        parkingLot.unParkVehicle(bike1);
        
        parkingLot.displayAvailableSpots();

        parkingLot.parkVehicle(bike1);

        parkingLot.displayAvailableSpots();
    }
}
