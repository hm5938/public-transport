import java.util.UUID;

public class Taxi extends PublicTransport {
    private final static int INFO_BASIC=0;
    private final static int INFO_BOARDING=1;
    private final static int INFO_FARE=2;

    private static final int FARE_MINIMUN = 3000;
    private static final int FARE_DISTANCE = 1000;
    private static final double DISTANCE_BASIC = 1;
    private double distance = 0;
    private String destination = "";
    private double fare_sum = 0;


    Taxi() {
        setMax_passenger(4);
        setFuel_volume(100);
        setNUMBER(UUID.randomUUID());
        distance = 0;
        setFare(0);
        setState("일반");
        print(INFO_BASIC);
    }
    @Override
    public void print(int i) {
        String[] str = new String[3];

        str[INFO_BASIC] =
                "---------------------------"+
                        "\n택시번호 : " + getNUMBER() +
                "\n주유량 : " + getFuel_volume() +
                "\n상태 : " + getState()+
        "\n---------------------------";

        str[INFO_BOARDING] =
                "---------------------------"+
                        "\n탐승 승객 수 : " + getPassenger() +
                        "\n잔여 승객 수 : " + (getMax_passenger() - getPassenger()) +
                        "\n기본 요금 확인 : " + FARE_MINIMUN +
                        "\n목적지 : " + destination +
                        "\n목적지 까지 거리 : " + distance +
                        "\n지불할 요금 : " + getFare()+
                        "\n---------------------------";


        str[INFO_FARE] =
                "---------------------------"+
                        "\n주유량 : " + getFuel_volume() +
                        "\n상태 : " + getState() +
                        "\n누적 요금 : " + fare_sum+
                        "\n---------------------------";
        System.out.println(str[i]);
    }
    @Override
    public void changeState() {
        if (getState().equals("일반")) {
            setState("운행중");
        } else {
            setState("일반");
        }
        if(getFuel_volume()<10){
            setState("운행불가");
        }
    }

    @Override
    public void refuel(double volume) {
        if(getFuel_volume()+volume>=0){
            setFuel_volume(getFuel_volume()+volume);
            if(getFuel_volume()<10){
                setState("운행불가");
            }
        }else{
            alert("연료가 남아있지않아 명령을 수행할 수 없습니다.");
        }
    }

    public void boarding(int passenger, String destination, double distance) {
        if (getState().equals("일반")) {
            if(getMax_passenger()<passenger){
                alert("최대 승객 수 초과. 탐승할 수 있는 인원은 최대 " +getMax_passenger() +"명 입니다.");
            }else{
                setPassenger(passenger);
                this.destination=destination;
                this.distance = distance;
                CalculateFare();
                setState("운행중");
                print(INFO_BOARDING);
            }
        } else {
            alert("현재 탐승불가 상태입니다.");
        }

    }

    public void CalculateFare() {
        if (distance > DISTANCE_BASIC) {
            setFare(FARE_MINIMUN + (distance - DISTANCE_BASIC) * FARE_DISTANCE);
        } else {
            setFare(FARE_MINIMUN);
        }

    }

    public void FarePayment() {
        if(!getState().equals("일반")){
            System.out.println("최종 요금은 " + getFare() + "원 입니다.");
            fare_sum+=getFare();
            setPassenger(0);
            distance =0;
            destination="";
            setFare(0);
            setSpeed(0);

           if(getState().equals("운행중")) setState("일반");
        }else{
            alert("현재 승객이 타고있지 않습니다.");
        }
        print(INFO_FARE);
        if(getFuel_volume()<10) alert("주유 필요");
    }
}
