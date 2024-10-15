import java.util.Map;

public interface RestaurantChoosingStrategy {
    Restaurant chooseRestaurant(Map<Dish, Integer> orderMap);
}
