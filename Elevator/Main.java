public class Main{
    public static void main(String[] args){
        ElevatorController elevatorController = new ElevatorController(3, 5);

        elevatorController.requestElevator(2, 5);
        elevatorController.requestElevator(3, 1);
        elevatorController.requestElevator(4, 3);
        elevatorController.requestElevator(1, 5);
    }
}