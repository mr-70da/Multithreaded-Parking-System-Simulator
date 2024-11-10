import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Log logger = new Log();
        ArrayList<Ticket> tickets = logger.getInput();

        ArrayList<Car> cars = new ArrayList<>();

        for (Ticket ticket : tickets) {
            Car car = new Car(ticket, parkingLot);
            car.start();
            cars.add(car);
        }
        for (Car car : cars) {
            try {
                car.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        logger.printLogSummary(tickets);

    }
}
