import java.util.ArrayList;
import java.util.List;

public class BusStops {
    private static BusStops instance; // Tekil örnek
    private List<String> busStopsList; // Durakların listesi

    // Özel yapıcı, dışarıdan erişim engellenir
    private BusStops() {
        busStopsList = new ArrayList<>();
        busStopsList.add("Eyüpsultan");
        busStopsList.add("Sancaktepe");
        busStopsList.add("Sultanbeyli");
    }

    // Tekil örneği döndürür
    public static BusStops getInstance() {
        if (instance == null) {
            instance = new BusStops();
        }
        return instance;
    }

    // Durak listesini döndürür
    public List<String> getBusStopList() {
        return busStopsList;
    }
}
