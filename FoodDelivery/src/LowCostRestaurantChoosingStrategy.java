import java.util.List;
import java.util.Map;

public class LowCostRestaurantChoosingStrategy implements RestaurantChoosingStrategy{

    @Override
    public Restaurant chooseRestaurant(Map<Dish, Integer> orderMap){
        Restaurant restaurant = null;
        RestaurantManager restaurantManager = RestaurantManager.getRestaurantManager();
        Map<String, Restaurant> restaurantMap = restaurantManager.getRestaurantMap();
        for(Map.Entry<String, Restaurant> entry : restaurantMap.entrySet()) {
            if(entry.getValue().isOpen()){
                boolean flag = true;
                List<Dish> dishList = entry.getValue().getMenu().getDishList();
                for (Map.Entry<Dish, Integer> entry1 : orderMap.entrySet()) {
                    if (!dishList.contains(entry1.getKey())) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    restaurant = entry.getValue();
                    break;
                }
            }
        }
        return restaurant;
    }
}