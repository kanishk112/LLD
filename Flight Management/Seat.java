/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Seat {
    private final String seatNumber;
    private final SeatClass seatClass;
    private SeatStatus seatStatus;

    public Seat(String seatNumber, SeatClass seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.seatStatus = seatStatus.AVAILABLE;
    }

    public void seatReserved(){
        seatStatus = SeatStatus.RESERVED;
    }

    public void seatReleased(){
        seatStatus = SeatStatus.AVAILABLE;
    }
}
