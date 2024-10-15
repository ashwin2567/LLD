import java.util.Map;

public class Utility {
    static int nextOrderId = 1;
    static double calculateTotalBill(Map<Dish, Integer> dishQuantityMap){
        double totalAmount = 0;
        for(Map.Entry<Dish, Integer> entry : dishQuantityMap.entrySet()){
            Dish dish = entry.getKey();
            int quantity = entry.getValue();
            totalAmount += dish.getPrice() * quantity;
        }
        return totalAmount;
    }
}
