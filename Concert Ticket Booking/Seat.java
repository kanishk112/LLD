/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Seat {
    private final String seatId;
    private final String seatNumber;
    private final SeatClass seatClass;
    private SeatStatus seatStatus;
    private final double price;

    public Seat(String seatId, String seatNumber, SeatClass seatClass, double price) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.seatStatus = seatStatus.AVAILABLE;
        this.price = price;
    }

    public synchronized void seatBooking(){
        if(seatStatus == SeatStatus.AVAILABLE){
            seatStatus = SeatStatus.RESERVED;
        } else{
            throw new SeatNotAvailableException("Seat is already occupied");
        }
    }

    public synchronized void seatRelease(){
        if(seatStatus == SeatStatus.RESERVED){
            seatStatus = SeatStatus.AVAILABLE;
        }
    }

    public double getPrice(){
        return price;
    }

    public String getSeatId(){
        return seatId;
    }

    public String getSeatNumber(){
        return seatNumber;
    }

    public SeatClass getSeatClass(){
        return seatClass;
    }

    public SeatStatus getSeatStatus(){
        return seatStatus;
    }
}

