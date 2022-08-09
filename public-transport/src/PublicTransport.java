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

    void StartDrive(){
        if(fuel_volume>=10) {

        }else{
            System.out.println("주유상태를 체크해주세요");
        }
    }
    void ChangeState() {}

    public void ChangeState(String str){
        state = str;
    }

    public void Boarding(){}

    public void ChangeSpeed(double s){
        if(fuel_volume<10){
            System.out.println("주유량을 확인해 주세요");
        }else{
            speed +=s;
        }
    };
}
