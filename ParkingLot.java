import java.util.concurrent.Semaphore;

public class ParkingLot implements Runnable {
    Semaphore ayhaga ;
    @Override
    public void run(){
        try {
            ayhaga.acquire();
        }catch (InterruptedException e){
        }

    }

}
