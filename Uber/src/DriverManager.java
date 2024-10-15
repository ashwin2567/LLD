import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    static volatile DriverManager driverManager = null;

    Map<String,Driver> driverMap;
    private DriverManager(){
        driverMap = new HashMap<>();
    }
    public static DriverManager getDriverManager(){
        if(driverManager == null){
            synchronized ((DriverManager.class)){
                if(driverManager == null){
                    driverManager = new DriverManager();
                }
            }
        }
        return driverManager;
    }

    public void addDriver(String name, Driver driver){
        driverMap.put(name, driver);
    }

    public Map<String, Driver> getDriverMap() {
        return driverMap;
    }
}
