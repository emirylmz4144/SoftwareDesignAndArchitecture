//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BusStops busStops=BusStops.getInstance();
        busStops.getBusStopList();
        BusStops busStops2=BusStops.getInstance();
        busStops2.getBusStopList();

        if (busStops==busStops2){
            System.out.println("Singleton");
        }
        else {
            System.out.println("Prototype");
        }
    }
}