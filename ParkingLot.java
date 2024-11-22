import java.util.LinkedList;
import java.util.Queue;

public class ParkingLot {
    //private final Semaphore slots;
    private int slots = 4;
    //private final int totalSlots = 4;
    private Queue<Car> waitingQueue;
    private int occupiedSlots = 0;
    private Log logger;

    public ParkingLot() {
        //this.slots = new Semaphore(totalSlots, true);
        this.waitingQueue = new LinkedList<>();
        logger = new Log();
    }

    public void addCarToQueue(Car car) {
        synchronized (this) {
            waitingQueue.add(car);
        }
    }

    public void tryPark(Car car) throws InterruptedException {
        synchronized (this) {
            logger.logArrive(car);
            Boolean hasWaited = false;
            if (this.slots == 0)
            {
                hasWaited = true;
                logger.logWait(car);

            }
            while (this.slots == 0 || waitingQueue.peek() != car) {
                wait();
            }


            this.slots--;
            occupiedSlots++;
            waitingQueue.poll();

            if (hasWaited) {
                logger.logParkAFterWait(car, occupiedSlots);
            } else {
                logger.logPark(car, occupiedSlots);
            }
        }
    }

    public synchronized void leave(Car car) {
        this.slots++;
        occupiedSlots--;
        logger.logLeave(car, occupiedSlots);
        if (!waitingQueue.isEmpty()) {
            Car nextCar = waitingQueue.peek();
            nextCar.setWaitingTime(car.getArrivalTime(),car.getParkDuration(),car.getWaitingTime());
        }

        notifyAll();
    }
}
