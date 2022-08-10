import java.util.UUID;

public abstract class PublicTransport {
    UUID NUMBER;
    int passenger=0;
    double fuel_volume =100;
    double speed =0;
    //속도변경
    int max_passenger =0;
    double fare=0;
    String state;

    public abstract void refuel(double volume);
    public abstract void print(int i);
    public void alert(String str){
        System.out.println("alert : "+ str);
    }

}
