import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Log l  = new Log();
        ArrayList<Ticket> t = l.getInput();
        for(Ticket s : t){
            System.out.print("gate: "+s.gate+ " ");
            System.out.print("car: "+s.car+ " ");
            System.out.print("arrives: "+s.arrive+" ");
            System.out.println("parks: "+s.parks);
        }

    }
}
