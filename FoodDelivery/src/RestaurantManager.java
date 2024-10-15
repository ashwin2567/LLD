import java.util.HashMap;
import java.util.Map;

public class RestaurantManager {
    static volatile RestaurantManager restaurantManager = null;
    private RestaurantManager(){
        restaurantMap = new HashMap<>();
    }

    public static RestaurantManager getRestaurantManager(){
        if(restaurantManager == null){
            synchronized (RestaurantManager.class){
                if(restaurantManager == null){
                    restaurantManager = new RestaurantManager();
                }
            }
        }
        return restaurantManager;
    }

    Map<String, Restaurant> restaurantMap;

    void addRestaurant(Restaurant restaurant){
        restaurantMap.put(restaurant.getName(), restaurant);
    }

    public Map<String, Restaurant> getRestaurantMap() {
        return restaurantMap;
    }

    void displayAllRestaurant(){
        for(Map.Entry<String, Restaurant> entry : restaurantMap.entrySet()){
            System.out.print(entry.getKey() + ", ");
        }
        System.out.println();
    }
}
