import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Log {
    public ArrayList<Ticket> getInput(){
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
        Collections.sort(tickets, Comparator.comparing(Ticket::getArrive));
        return tickets;
    }
}
