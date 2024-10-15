import jdk.jshell.execution.Util;

import java.util.Map;

public class Order {
    int orderId;
    Customer customer;
    Restaurant restaurant;
    Map<Dish, Integer> dishQuantityMap;
    double totalBill;

    public Order(Customer customer, Map<Dish, Integer> dishQuantityMap) {
        this.orderId = Utility.nextOrderId++;
        this.customer = customer;
        this.dishQuantityMap = dishQuantityMap;
        this.totalBill = Utility.calculateTotalBill(dishQuantityMap);
    }

    public double getTotalBill() {
        return totalBill;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getRestaurantName() {
        return restaurant.getName();
    }

    public Map<Dish, Integer> getDishQuantityMap() {
        return dishQuantityMap;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
