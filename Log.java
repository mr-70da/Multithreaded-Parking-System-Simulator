import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Log {
    public ArrayList<Ticket> getInput() throws Exception{
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {

            File file = new File("input.txt");
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                Ticket ticket = new Ticket();
                String[] information = data.split(",");
                String[] values;
                values = information[0].trim().split(" ");
                ticket.gate = Integer.parseInt(values[1]);
                values = information[1].trim().split(" ");
                ticket.car = Integer.parseInt(values[1]);
                values = information[2].trim().split(" ");
                ticket.arrive = Integer.parseInt(values[1]);
                values = information[3].trim().split(" ");
                ticket.parks = Integer.parseInt(values[1]);
                tickets.add(ticket);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        Collections.sort(tickets, Comparator.comparing(Ticket::getArrive).thenComparing(Ticket::getParks));
        for(int i = 1; i < tickets.size(); ++i)
        {
            if(tickets.get(i).getArrive() == tickets.get(i-1).getArrive() && tickets.get(i).getGate() == tickets.get(i-1).getGate())
                throw new InvalidInputException();
            if(tickets.get(i-1).getParks() < 1 || tickets.get(i-1).getArrive() < 0)
                throw new InvalidTimeException();
            if(tickets.get(i-1).getGate() < 1 || tickets.get(i-1).getGate() > 4)
                throw new InvalidGateException();
        }
        if(tickets.get(tickets.size()-1).getParks() < 1 || tickets.get(tickets.size()-1).getArrive() < 0)
            throw new InvalidTimeException();
        if(tickets.get(tickets.size()-1).getGate() < 1 || tickets.get(tickets.size()-1).getGate() > 4)
                throw new InvalidGateException();

        return tickets;
    }

    public void logArrive(Car car){
        String arrivalMessage = "Car " + car.getCarId() + " from Gate "+ car.getGateId()+ " arrived at time " + car.getArrivalTime();
        System.out.println(arrivalMessage);;
    }

    public void logWait(Car car){
        String waitingMessage = "Car " + car.getCarId() + " from Gate "+ car.getGateId()+ " waiting for a spot. ";
        System.out.println(waitingMessage);;
    }

    public void logPark(Car car, int occupiedSlots){
        String parkedMessage = "Car " + car.getCarId() + " from Gate "+ car.getGateId()+ " parked." + " (Parking Status: "+occupiedSlots+" spots occupied)";
        System.out.println(parkedMessage);;
    }

    public void logLeave(Car car, int occupiedSlots){
        String leaveMessage = "Car " + car.getCarId() + " from Gate "+ car.getGateId()+ " left after " + car.getParkDuration() + " units of time." + " (Parking Status: "+occupiedSlots+" spots occupied)";
        System.out.println(leaveMessage);;
    }

    public void logParkAFterWait(Car car, int occupiedSlots)
    {
       
        String parkAfterWaitMessage = "Car " + car.getCarId() + " from Gate "+ car.getGateId()+ " parked after waiting for " + car.getWaitingTime() + " units of time."+ " (Parking Status: "+occupiedSlots+" spots occupied)";
        System.out.println(parkAfterWaitMessage);
    }

    public void printLogSummary(ArrayList<Ticket> tickets){
       int servedGates[] = new int[4];

        for (Ticket ticket : tickets) {
            servedGates[ticket.getGate()]++;
        }
        String summary = "\n...\nTotal Cars Served: " + tickets.size() + "\nCurrent Cars in Parking: 0" + "\nDetails:" + "\n-Gate 1 served " + servedGates[1]+ " cars." + "\n-Gate 2 served " + servedGates[2]+ " cars." + "\n-Gate 3 served " + servedGates[3]+ " cars.";
        System.out.println(summary);

    }



}
