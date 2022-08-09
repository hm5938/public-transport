import java.util.UUID;

public class Bus extends PublicTransport {


    //생성자
    Bus() {
        NUMBER = UUID.randomUUID();
        max_passenger = 30;
        fare = 1000;
        state = "운행";
    }

    public void print(int i) {
        String[] str = new String[3];

        str[0] = "버스번호 : " + NUMBER +
                "주유량 : " + fuel_volume +
                "상태 : " + state;
        str[1] =
                "탐승 승객 수 : " + passenger +
                        "잔여 승객 수 : " + (max_passenger - passenger) +
                        "요금 확인 : " + fare;
        str[2] =
                "주유량 : " + fuel_volume +
                        "상태 : " + state;
        System.out.println(str[i]);
    }

    @Override
    public void ChangeState() {
        if (state.equals("운행")) {
            state = "차고지행";
        } else {
            state = "운행";
        }
    }

    public void checkFoil() {
        if (fuel_volume <= 0) {
            ChangeState("차고지행");
        } else if (fuel_volume < 10) {
            System.out.println("주유가 필요하다");
        }
    }


    @Override
    public void Boarding() {
        if (state.equals("운행")) {
            if (passenger < max_passenger) passenger++;
            else System.out.println("최대 인원을 초과하였습니다.");
        }

    }
}
