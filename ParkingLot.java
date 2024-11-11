import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class ParkingLot {
    private final Semaphore slots;
    private final int totalSlots = 4;
    private Queue<Car> waitingQueue;
    private int occupiedSlots = 0;
    private Log logger;

    public ParkingLot() {
        this.slots = new Semaphore(totalSlots, true);
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
            if (slots.availablePermits() == 0)
            {
                hasWaited = true;
                logger.logWait(car);

            }
            while (slots.availablePermits() == 0 || waitingQueue.peek() != car) {
                wait();
            }


            slots.acquire();
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
        slots.release();
        occupiedSlots--;
        logger.logLeave(car, occupiedSlots);
        if (!waitingQueue.isEmpty()) {
            Car nextCar = waitingQueue.peek();
            nextCar.setWaitingTime(car.getArrivalTime(),car.getParkDuration(),car.getWaitingTime());
        }

        notifyAll();
    }
}
