/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


class ParkingSpot {
    private final int spotNumber;
    private final vehicleType vType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, vehicleType vType){
        this.spotNumber = spotNumber;
        this.vType = vType;
    }

    public int getSpotNumber(){
        return spotNumber;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getVehicleType() == vType){
            parkedVehicle = vehicle;
        } else{
            System.out.println("Invalid Vehicle Type or Spot  is already occupied");
        }
    }

    public synchronized void unParkVehicle(){
        parkedVehicle = null;
    }

    public vehicleType getVehicleType(){
        return vType;
    }

    public Vehicle getParkedVehicle(){
        return parkedVehicle;
    }

}
