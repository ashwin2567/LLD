public class StrategyManager {
    static volatile StrategyManager strategyManager = null;
    private StrategyManager(){
    }
    public static StrategyManager getStrategyManager(){
        if(strategyManager == null){
            synchronized (StrategyManager.class){
                if(strategyManager == null){
                    strategyManager = new StrategyManager();
                }
            }
        }
        return strategyManager;
    }

    RestaurantChoosingStrategy restaurantChoosingStrategy(double orderValue){
        if(orderValue > 100 ){
            return new LowCostRestaurantChoosingStrategy();
        }
        else{
            return new DefaultRestaurantChoosingStrategy();
        }
    }
}
