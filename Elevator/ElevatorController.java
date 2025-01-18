
import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;
    public ElevatorController(int numElevators, int capacity) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            Elevator elevator = new Elevator(i, capacity);
            elevators.add(elevator);
            new Thread(elevator::move).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator elevator = findElevator(sourceFloor, destinationFloor);
        if (elevator != null) {
            elevator.addRequest(new Request(sourceFloor, destinationFloor));
        }
    }

    private Elevator findElevator(int sourceFloor, int destinationFloor) {
        Elevator selectedElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - destinationFloor);
            if (distance < minDistance) {
                minDistance = distance;
                selectedElevator = elevator;
            }
        }
        return selectedElevator;
    }
}