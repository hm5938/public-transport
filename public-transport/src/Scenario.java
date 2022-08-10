public class Scenario {
    public static void main(String[] args) {
        Scenario scenario = new Scenario();
        scenario.TaxiScen();
        scenario.BusScen();
    }
    public void BusScen(){
        //### Bus
        //
        //1. **Bus** - 2대 생성
        Bus bus1 = new Bus(), bus2 = new Bus();
        //**※ Bus 1대로 진행**
        //
        //1. **Bus**
        //    1.  승객 +2
        bus1.boarding(2);
        //3. **Bus**
        //    1. 주유량 -50
        bus1.refuel(-50);
        //5. **Bus - 상태 변경**
        //    1. 차고지행
        bus1.ChangeState();
        //6. **Bus**
        //    1. 주유량 +10
        bus1.refuel(10);
        //8. **Bus -** **상태 변경**
        //    1. 운행중
        bus1.ChangeState();
        //9. **Bus**
        //    1. 승객 +45
        bus1.boarding(45);
        //11. **Bus**
        //    1. 승객 +5
        bus1.boarding(5);

        //13. **Bus**
        //    1. 주유량 -55
        bus1.refuel(-55);
    }
    //### Taxi
    public void TaxiScen(){
        //1. **Taxi** - 2대 생성
        Taxi taxi1 = new Taxi(), taxi2 = new Taxi();
        //**※ Taxi 1대로 진행**
        //1. **Taxi**
        //    1.  승객 +2
        //    2. 목적지 = 서울역
        //    3. 목적지까지 거리 = 2km
        taxi1.boarding(2,"서울역",2);

        //3. **Taxi**
        //    1. 주유량 -80
        taxi1.refuel(-80);
        //4. **Taxi -** **요금 결제**
        taxi1.FarePayment();
        //6. **Taxi**
        //    1. 승객 +5
        taxi1.boarding(5,"",0);
        //8. **Taxi**
        //    1. 승객 +3
        //    2. 목적지 = 구로디지털단지역
        //    3. 목적지까지 거리 = 12km
        taxi1.boarding(3,"구로디지털단지역",12);
        //10. **Taxi**
        //    1. 주유량 -20
        taxi1.refuel(-20);
        //11. **Taxi - 요금 결제**
        taxi1.FarePayment();
    }
    
}
