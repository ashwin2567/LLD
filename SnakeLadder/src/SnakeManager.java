import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeManager {
    Map<Integer, Integer> snakeMap;
    private static volatile SnakeManager snakeManager = null;
    public static SnakeManager getSnakeManager(){
        if(snakeManager == null){
            synchronized (SnakeManager.class){
                if(snakeManager == null){
                    snakeManager = new SnakeManager();
                }
            }
        }
        return snakeManager;
    }

    private SnakeManager(){
        snakeMap = new HashMap<>();
    }

    public Map<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    void displayAllSnakes(){
        int i = 1;
        for(Map.Entry<Integer, Integer> entry : snakeMap.entrySet()){
            System.out.println("Snake " + i + ":" + entry.getKey() + " " + entry.getValue());
            i++;
        }
    }
}
