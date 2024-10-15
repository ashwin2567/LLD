import java.util.HashMap;
import java.util.Map;

public class TripManager {
    static volatile TripManager tripManager = null;
    RiderManager riderManager;
    DriverManager driverManager;
    Map<Integer, Trip> tripMap = new HashMap<>();
    Map<Integer, TripMetaData> tripMetaDataMap = new HashMap<>();

    private TripManager(){
        riderManager = RiderManager.getRiderManager();
        driverManager = DriverManager.getDriverManager();
    }

    public static TripManager getTripManager(){
        if(tripManager == null){
            synchronized ((TripManager.class)){
                if(tripManager == null){
                    tripManager = new TripManager();
                }
            }
        }
        return tripManager;
    }
    void createTrip(Rider rider, Location srcLoc, Location desLoc){
        TripMetaData tripMetaData = new TripMetaData(srcLoc, desLoc,rider.getRating());
        StrategyManager strategyManager = StrategyManager.getStrategyManager();

        PricingStrategy pricingStrategy = strategyManager.determinePricingStrategy(tripMetaData);
        double price = pricingStrategy.calculatePrice(tripMetaData);

        DriverMatchingStrategy driverMatchingStrategy = strategyManager.determineDriverMatchingStrategy(tripMetaData);
        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);

        Trip trip = new Trip(driver, rider, srcLoc, desLoc, price, pricingStrategy,driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripMap.put(tripId, trip);
        tripMetaDataMap.put(tripId, tripMetaData);
    }

    public Map<Integer, Trip> getTripMap() {
        return tripMap;
    }
}
