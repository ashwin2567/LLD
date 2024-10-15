import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    static volatile OrderManager orderManager = null;
    Map<Integer, Order> allOrderMap;
    private OrderManager(){
        allOrderMap = new HashMap<>();
    }
    public static OrderManager getOrderManager(){
        if(orderManager == null){
            synchronized (OrderManager.class){
                if(orderManager == null){
                    orderManager = new OrderManager();
                }
            }
        }
        return orderManager;
    }

    void createOrder(Customer customer, Map<Dish, Integer> orderMap){
        Order order = new Order(customer,orderMap);
        StrategyManager strategyManager = StrategyManager.getStrategyManager();
        RestaurantChoosingStrategy restaurantChoosingStrategy = strategyManager.restaurantChoosingStrategy(order.getTotalBill());
        Restaurant restaurant = restaurantChoosingStrategy.chooseRestaurant(orderMap);
        try {
            allOrderMap.put(order.getOrderId(), order);
            order.setRestaurant(restaurant);
            restaurant.setCurrCapacity(restaurant.getCurrCapacity() + 1);
            if(restaurant.getCurrCapacity() ==restaurant.getMaxCapacity()){
                restaurant.setOpen(false);
            }
        }
        catch (Exception e){
            throw new RuntimeException("No restaurant can serve this Order.");
        }
    }

    void displayAllOrder(){
        try {
            for (Map.Entry<Integer, Order> entry : allOrderMap.entrySet()) {
                System.out.println();
                Order order = entry.getValue();
                System.out.println("Order Id" + entry.getKey() + ", Total Bill: " + order.getTotalBill());
                System.out.println("Customer Name: " + order.getCustomerName() + ", Restaurant Name: " + order.getRestaurantName() + "(" + order.getRestaurant().getCurrCapacity() + "/" + order.getRestaurant().getMaxCapacity() + ")");
                for (Map.Entry<Dish, Integer> entryDish : order.getDishQuantityMap().entrySet()) {
                    System.out.println(entryDish.getKey().getName() + " : " + entryDish.getValue());
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println("Details not found.");
        }
    }
}
