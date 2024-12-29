/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public abstract class Vehicle {
    protected String licenseNo;
    protected vehicleType vType;

    public Vehicle(String licenseNo, vehicleType vType){
        this.licenseNo = licenseNo;
        this.vType = vType;
    }

    public vehicleType getVehicleType(){
        return vType;
    }

}
