
import java.util.ArrayList;
import java.util.List;

public class Elevator{
    private final int id;
    private int currentFloor;;
    private Direction direction;
    private final List<Request> requests;
    private final int capacity;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.UP;
        this.requests = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public synchronized void addRequest(Request request) {
        if(requests.size() < capacity) {
            requests.add(request);
            System.out.println("Elevator " + id + " received request: " + request);
            notifyAll();
        }
    }

    private void processRequest(Request request) {
        int startFloor = currentFloor;
        int endFloor = request.getDestinationFloor();

        if(startFloor < endFloor) {
            direction = Direction.UP;
            for(int i = startFloor; i <= endFloor; i++) {
                currentFloor = i;
                System.out.println("Elevator " + id + " is moving to floor: " + i);
                try {
                    Thread.sleep(1000); // TO simulate moving to next floor
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if(startFloor > endFloor) {
            direction = Direction.DOWN;
            for(int i = startFloor; i >= endFloor; i--) {
                currentFloor = i;
                System.out.println("Elevator " + id + " is moving to floor: " + i);
                try {
                    Thread.sleep(1000); // TO simulate moving to next floor
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void processRequests() {
        while (true) {
            while (!requests.isEmpty()) {
                Request request = requests.remove(0);
                processRequest(request);
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized Request getNextRequest() {
        while (requests.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return requests.remove(0);
    }

    public void move(){
        processRequests();
    }
}