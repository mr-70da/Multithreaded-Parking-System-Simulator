

public class Car extends Thread {
    private int carId;
    private int gateId;
    private int arrivalTime;
    private int parkDuration;
    private int waitingTime;
    private  ParkingLot parkingLot;
    public Car(Ticket ticket, ParkingLot parkingLot){
        this.carId = ticket.car;
        this.gateId = ticket.gate;
        this.parkDuration = ticket.parks;
        this.arrivalTime = ticket.arrive;
        this.parkingLot = parkingLot;
    }
    public int getCarId(){
        return carId;
    }
    public int getGateId(){
        return gateId;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getParkDuration(){
        return parkDuration;
    }
    public int getWaitingTime(){
        return waitingTime;
    }
    public synchronized void setWaitingTime(int prevCarArrival, int prevCarDuration,int prevWaiting){
        this.waitingTime = (prevCarArrival + prevCarDuration + prevWaiting) - arrivalTime;
    }

    public void run() {
        try {
            Thread.sleep(arrivalTime * 1000);

            parkingLot.addCarToQueue(this);

            parkingLot.tryPark(this);

            Thread.sleep(parkDuration * 1000);

            parkingLot.leave(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
