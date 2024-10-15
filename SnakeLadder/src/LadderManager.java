import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderManager {
    Map<Integer, Integer> ladderMap;
    private static volatile LadderManager ladderManager = null;
    public static LadderManager getLadderManager(){
        if(ladderManager == null){
            synchronized (LadderManager.class){
                if(ladderManager == null){
                    ladderManager = new LadderManager();
                }
            }
        }
        return ladderManager;
    }
    private LadderManager(){
        ladderMap = new HashMap<>();
    }

    public Map<Integer, Integer> getLadderMap() {
        return ladderMap;
    }

    void displayAllLadders(){
        int i = 1;
        for(Map.Entry<Integer, Integer> entry : ladderMap.entrySet()){
            System.out.println("Ladder " + i + ":" + entry.getKey() + " " + entry.getValue());
            i++;
        }
    }
}
