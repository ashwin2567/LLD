import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Hello world!");
            Customer ashwinCustomer = new Customer("Ashwin");
            Customer ankitCustomer = new Customer("Ankit");
            CustomerManager customerManager = CustomerManager.getCustomerManager();
            customerManager.addCustomer(ashwinCustomer);
            customerManager.addCustomer(ankitCustomer);
            //customerManager.displayAllCustomer();

            Dish Idli = new Dish(FoodItem.IDLI, 10.00);
            Dish Dosa = new Dish(FoodItem.DOSA, 20);
            Dish Paratha = new Dish(FoodItem.PARATHA, 15.50);
            Dish Paneer = new Dish(FoodItem.PANEER, 25);

            Menu southMenu = new Menu(new ArrayList<>(Arrays.asList(Idli, Dosa)));
            Menu northMenu = new Menu(new ArrayList<>(Arrays.asList(Paneer, Paratha)));

            Restaurant defaultRestaurant = new Restaurant("Default", northMenu, 10);
            Restaurant southRestaurant = new Restaurant("South Reso", southMenu, 1);
            Restaurant northRestaurant = new Restaurant("North Reso", northMenu, 1);
            RestaurantManager restaurantManager = RestaurantManager.getRestaurantManager();
            restaurantManager.addRestaurant(northRestaurant);
            restaurantManager.addRestaurant(southRestaurant);
            restaurantManager.addRestaurant(defaultRestaurant);
            //restaurantManager.displayAllRestaurant();

            OrderManager orderManager = OrderManager.getOrderManager();
            Map<Dish, Integer> orderMap1 = new HashMap<>();
            orderMap1.put(Paratha, 30);
            orderMap1.put(Paneer, 1);

            Map<Dish, Integer> orderMap2 = new HashMap<>();
            orderMap2.put(Idli, 12);
            orderMap2.put(Dosa, 10);
            //Restaurant will be decided by strategy
            orderManager.createOrder(ashwinCustomer, orderMap1);

            orderManager.createOrder(ankitCustomer, orderMap2);
            orderManager.createOrder(ashwinCustomer, orderMap2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            OrderManager.orderManager.displayAllOrder();
        }
    }
}