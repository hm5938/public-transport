import java.util.UUID;

public abstract class PublicTransport {
    private UUID NUMBER;
    private int passenger=0;
    private double fuel_volume =100;
    private double speed =0;
    //속도변경
    private int max_passenger =0;
    private double fare=0;
    private String state;
    public int getPassenger() {
        return passenger;
    }
    public int getMax_passenger() {
        return max_passenger;
    }
    public double getFuel_volume() {
        return fuel_volume;
    }
    public UUID getNUMBER() {
        return NUMBER;
    }
    public String getState() {
        return state;
    }
    public double getSpeed() {
        return speed;
    }
    public double getFare() {
        return fare;
    }
    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }
    public void setMax_passenger(int max_passenger) {
        this.max_passenger = max_passenger;
    }
    public void setFuel_volume(double fuel_volume) {
        this.fuel_volume = fuel_volume;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void setNUMBER(UUID NUMBER) {
        this.NUMBER = NUMBER;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setFare(double fare) {
        this.fare = fare;
    }

    public abstract void refuel(double volume);
    public abstract void print(int i);
    public void alert(String str){
        System.out.println("alert : "+ str);
    }

}
