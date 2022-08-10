import java.util.UUID;

public class Taxi extends PublicTransport {
    private final static int PRINT_1=0;
    private final static int PRINT_2=1;
    private final static int PRINT_3=2;

    private static final int FARE_MINIMUN = 3000;
    private static final int FARE_DISTANCE = 1000;
    private static final double DISTANCE_BASIC = 1;
    private double distance = 0;
    private String destination = "";
    private double fare_sum = 0;


    Taxi() {
        max_passenger = 4;
        fuel_volume = 100;
        NUMBER = UUID.randomUUID();
        distance = 0;
        fare = 0;
        state = "일반";
        print(0);
    }
    @Override
    public void print(int i) {
        String[] str = new String[3];

        str[0] =
                "---------------------------"+
                        "\n택시번호 : " + NUMBER +
                "\n주유량 : " + fuel_volume +
                "\n상태 : " + state+
        "\n---------------------------";

        str[1] =
                "---------------------------"+
                        "\n탐승 승객 수 : " + passenger +
                        "\n잔여 승객 수 : " + (max_passenger - passenger) +
                        "\n기본 요금 확인 : " + FARE_MINIMUN +
                        "\n목적지 : " + destination +
                        "\n목적지 까지 거리 : " + distance +
                        "\n지불할 요금 : " + fare+
                        "\n---------------------------";


        str[2] =
                "---------------------------"+
                        "\n주유량 : " + fuel_volume +
                        "\n상태 : " + state +
                        "\n누적 요금 : " + fare_sum+
                        "\n---------------------------";
        System.out.println(str[i]);
    }

    @Override
    public void refuel(double volume) {
        if(fuel_volume+volume>=0){
            fuel_volume += volume;
            if(fuel_volume<10){
                state = "운행불가";
            }
        }else{
            alert("연료가 남아있지않아 명령을 수행할 수 없습니다.");
        }
    }

    public void boarding(int passenger, String destination, double distance) {
        if (state.equals("일반")) {
            if(max_passenger<passenger){
                alert("최대 승객 수 초과. 탐승할 수 있는 인원은 최대 " +max_passenger +"명 입니다.");
            }else{
                this.passenger = passenger;
                this.destination=destination;
                this.distance = distance;
                CalculateFare();
                state = "운행중";
                print(1);
            }
        } else {
            alert("현재 탐승불가 상태입니다.");
        }

    }

    public void CalculateFare() {
        if (distance > DISTANCE_BASIC) {
            fare = FARE_MINIMUN + (distance - DISTANCE_BASIC) * FARE_DISTANCE;
        } else {
            fare = FARE_MINIMUN;
        }

    }

    public void FarePayment() {
        if(!state.equals("일반")){
            System.out.println("최종 요금은 " + fare + "원 입니다.");
            fare_sum+=fare;
            passenger =0;
            distance =0;
            destination="";
            fare=0;

           if(state.equals("운행중")) state = "일반";
        }else{
            alert("현재 승객이 타고있지 않습니다.");
        }
        print(2);
        if(fuel_volume<10) alert("주유 필요");
    }
}
