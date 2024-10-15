import java.util.Objects;

public class StrategyManager {
    static volatile StrategyManager strategyManager = null;
    private StrategyManager(){}
    public static StrategyManager getStrategyManager(){
        if(strategyManager == null){
            synchronized ((StrategyManager.class)){
                if(strategyManager == null){
                    strategyManager = new StrategyManager();
                }
            }
        }
        return strategyManager;
    }
    PricingStrategy determinePricingStrategy(TripMetaData tripMetaData){
        // main calculation of deciding strategy goes here
        Location loc = new Location(1, 1);
        if(Objects.equals(tripMetaData.getSrcLoc().latitude, loc.latitude) && Objects.equals(tripMetaData.getSrcLoc().longitude, loc.longitude)){
            System.out.println("Based on location 1, setting default pricing strategy");
            return new DefaultPricingStrategy();
        }
        else {
            System.out.println("Based on no loc rating factors, setting rating  pricing strategy");
            return new RatingBasedPricingStrategy();
        }
    }

    DriverMatchingStrategy determineDriverMatchingStrategy(TripMetaData tripMetaData){
        // main calculation of deciding strategy goes here
        Location loc = new Location(1, 1);
        if(Objects.equals(tripMetaData.getSrcLoc().latitude, loc.latitude) && Objects.equals(tripMetaData.getSrcLoc().longitude, loc.longitude)) {
            System.out.println("Based on location 1, setting QuadTreeBasedDriverMatchingStrategy Ankita");
            return new QuadTreeBasedDriverMatchingStrategy();
        }
        else {
            System.out.println("Based on certain no loc factors setting LeastTimeBasedDriverMatchingStrategy");
            return new LeastTimeBasedDriverMatchingStrategy();
        }
    }
}
