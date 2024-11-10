import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        Log logger = new Log();
        ArrayList<Ticket> tickets = logger.getInput();  

   
     
        for (Ticket ticket : tickets) {
            Car car = new Car(ticket, parkingLot);
            car.start();
        }   

     

        //logger.logSummary(tickets);
    }
}
