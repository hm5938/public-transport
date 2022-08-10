import java.util.UUID;

public class Bus extends PublicTransport {
    private final static int PRINT_1=0;
    private final static int PRINT_2=1;
    private final static int PRINT_3=2;


    Bus() {
        NUMBER = UUID.randomUUID();
        max_passenger = 30;
        fare = 1000;
        state = "운행";
        print(0);
    }
    @Override
    public void print(int i) {
        String[] str = new String[3];

        str[0] = "---------------------------"+
                "\n버스번호 : " + NUMBER +
                "\n주유량 : " + fuel_volume +
                "\n상태 : " + state+
                "\n---------------------------";
        str[1] =
                "---------------------------"+
                        "\n탐승 승객 수 : " + passenger +
                        "\n잔여 승객 수 : " + (max_passenger - passenger) +
                        "\n요금 확인 : " + fare+
                        "\n---------------------------";
        str[2] =
                "---------------------------"+
                        "\n주유량 : " + fuel_volume +
                        "\n상태 : " + state+
                        "\n---------------------------";
        System.out.println(str[i]);
    }

    public void ChangeState() {
        if (state.equals("운행")) {
            state = "차고지행";
            passenger =0;
        } else {
            state = "운행";
        }
    }

    public void boarding(int passenger) {
        if (state.equals("운행")) {
            if(max_passenger<passenger){
                alert("최대 승객 수 초과. 탐승할 수 있는 인원은 최대 " +max_passenger +"명 입니다.");
            }else{
                this.passenger += passenger;
                this.fare= this.passenger*1000;
                print(1);
            }
        } else {
            alert("현재 탐승불가 상태입니다.");
        }

    }

    @Override
    public void refuel(double volume) {
        if(fuel_volume+volume>=0){
            fuel_volume += volume;
            if(fuel_volume<10){
                if(state.equals("운행"))ChangeState();
                print(2);
                alert("주유가 필요합니다.");
            }else{
                print(2);
            }
        }else{
            alert("연료가 남아있지않아 명령을 수행할 수 없습니다.");
        }}
}
