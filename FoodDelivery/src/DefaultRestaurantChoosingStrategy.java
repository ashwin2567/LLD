import java.util.Map;

public class DefaultRestaurantChoosingStrategy implements RestaurantChoosingStrategy{

    @Override
    public Restaurant chooseRestaurant(Map<Dish, Integer> orderMap) {
        RestaurantManager restaurantManager = RestaurantManager.getRestaurantManager();
        Map<String, Restaurant> restaurantMap = restaurantManager.getRestaurantMap();
        System.out.println("Based on certain factors we choose default reso");
        return restaurantMap.values().stream().toList().get(2);
    }
}
