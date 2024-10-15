import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    static volatile RiderManager riderManager = null;
    Map<String, Rider> riderMap;
    private RiderManager(){
        riderMap = new HashMap<>();
    }
    public static RiderManager getRiderManager(){
        if(riderManager == null){
            synchronized ((RiderManager.class)){
                if(riderManager == null){
                    riderManager = new RiderManager();
                }
            }
        }
        return riderManager;
    }

    public void addRider(String name, Rider rider){
        riderMap.put(name, rider);
    }
}
