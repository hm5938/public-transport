import java.util.UUID;

public class Bus extends PublicTransport {
    private final static int INFO_BASIC=0;
    private final static int INFO_BOARDING=1;
    private final static int INFO_FARE=2;


    Bus() {
        setNUMBER(UUID.randomUUID());
        setMax_passenger(30);
        setFare(1000);
        setState("운행");
        print(INFO_BASIC);
    }
    @Override
    public void print(int i) {
        String[] str = new String[3];

        str[INFO_BASIC] = "---------------------------"+
                "\n버스번호 : " + getNUMBER() +
                "\n주유량 : " + getFuel_volume() +
                "\n상태 : " + getState()+
                "\n---------------------------";
        str[INFO_BOARDING] =
                "---------------------------"+
                        "\n탐승 승객 수 : " + getPassenger() +
                        "\n잔여 승객 수 : " + (getMax_passenger() - getPassenger()) +
                        "\n요금 확인 : " + getPassenger()*getFare()+
                        "\n---------------------------";
        str[INFO_FARE] =
                "---------------------------"+
                        "\n주유량 : " + getFuel_volume() +
                        "\n상태 : " + getState()+
                        "\n---------------------------";
        System.out.println(str[i]);
    }

    public void ChangeState() {
        if (getState().equals("운행")) {
            setState("차고지행");
           setPassenger(0);
        } else {
            setState("운행");
        }
    }

    public void boarding(int passenger) {
        if (getState().equals("운행")) {
            if(getMax_passenger()<passenger){
                alert("최대 승객 수 초과. 탐승할 수 있는 인원은 최대 " +getMax_passenger() +"명 입니다.");
            }else{
                setPassenger(getPassenger()+passenger);
                print(INFO_BOARDING);
            }
        } else {
            alert("현재 탐승불가 상태입니다.");
        }

    }

    @Override
    public void refuel(double volume) {
        if(getFuel_volume()+volume>=0){
            setFuel_volume(getFuel_volume()+volume);
            if(getFuel_volume()<10){
                if(getState().equals("운행"))ChangeState();
                print(INFO_FARE);
                alert("주유가 필요합니다.");
            }else{
                print(INFO_FARE);
            }
        }else{
            alert("연료가 남아있지않아 명령을 수행할 수 없습니다.");
        }}
}
