public class Ticket {
    int car;
    int gate;
    int arrive;
    int parks;
    public boolean comp(Ticket t1 , Ticket t2){
        return (t1.arrive<t2.arrive);
    }
}
