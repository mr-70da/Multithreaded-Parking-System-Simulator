public class Ticket {

    int car;
    int gate;
    int arrive;
    int parks;
    
    public int getArrive() {
        return arrive;
    }

    public int getDuration(){
        return parks;
    }

    public int getGate(){
        return gate;
    }
    public int getCarNum(){
        return car;
    }

    public boolean comp(Ticket t1 , Ticket t2){
        return (t1.arrive<t2.arrive);
    }
}
