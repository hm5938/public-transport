import java.util.UUID;

public class Taxi extends PublicTransport {
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
    }

    public void print(int i) {
        String[] str = new String[3];

        str[0] = "택시번호 : " + NUMBER +
                "주유량 : " + fuel_volume +
                "상태 : " + state;

        str[1] =
                "탐승 승객 수 : " + passenger +
                        "잔여 승객 수 : " + (max_passenger - passenger) +
                        "기본 요금 확인 : " + FARE_MINIMUN +
                        "목적지 : " + destination +
                        "목적지 까지 거리" + distance +
                        "지불할 요금" + fare;


        str[2] =
                "주유량 : " + fuel_volume +
                        "상태 : " + state +
                        "누적 요금 : " + fare_sum;
        System.out.println(str[i]);
    }


    @Override
    public void Boarding() {
        if (state.equals("일반")) {
            state = "운행중";
        } else {
            System.out.println("탐승불가입니다.");
        }

    }

    public void CalculateFare() {
        if (distance > DISTANCE_BASIC) {
            fare = FARE_MINIMUN + (distance - DISTANCE_BASIC) * 1000;
        } else {
            fare = FARE_MINIMUN;
        }

    }

    public void FarePayment() {
        System.out.println("최종 요금은 " + fare + "원 입니다.");
    }
}
//1. 택시 번호
//2. 주유량
//3. 현재속도
//4. 목적지
//5. 기본거리
//6. 목적지까지 거리
//7. 기본 요금
//8. 거리당 요금
//9. 상태 (운행 중, 일반)