import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    static volatile CustomerManager customerManager = null;
    private CustomerManager(){
        customerMap = new HashMap<>();
    }

    public static CustomerManager getCustomerManager(){
        if(customerManager == null){
            synchronized (CustomerManager.class){
                if(customerManager == null){
                    customerManager = new CustomerManager();
                }
            }
        }
        return customerManager;
    }

    Map<String, Customer> customerMap;

    void addCustomer(Customer customer){
        customerMap.put(customer.getName(), customer);
    }

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    void displayAllCustomer(){
        for(Map.Entry<String, Customer> entry : customerMap.entrySet()){
            System.out.print(entry.getKey() + ", ");
        }
        System.out.println();
    }
}
