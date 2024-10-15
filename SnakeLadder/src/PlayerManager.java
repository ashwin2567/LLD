import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PlayerManager {
    List<Player> playerList;
    PlayerManager(){
        playerList = new ArrayList<>();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    boolean toContinue(){
        for(int i=0;i<playerList.size();i++){
            if(Objects.equals(playerList.get(i).getCurr_position(), 100)){
                System.out.println(playerList.get(i).getName() + " is the winner.");
                return false;
            }
        }
        return true;
    }

    void displayAllPlayers(){
        for(int i=0;i<playerList.size();i++){
            System.out.println(playerList.get(i).getName());
        }
    }

    int getRandom(){
        Random r = new Random();
        int low = 1;
        int high = 7;
        return r.nextInt(high-low) + low;
    }
}
