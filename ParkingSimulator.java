import java.util.ArrayList;

public class ParkingSimulator {
    private Log logger;
    private ArrayList<Ticket> tickets;
    public ParkingSimulator(){
    }
    public void run(){
        tickets = logger.getInput();
        for(int i = 0 ; i < tickets.size(); ){
            int currentArrival = tickets.get(i).getArrive();
            while(i < tickets.size() && tickets.get(i).getArrive() == currentArrival ){
                i++;
            }
        }

    }



}
