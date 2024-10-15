import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> playerList;
    PlayerManager(){
        playerList = new ArrayList<>();
    }

    void addPlayer(Player player){
        if(playerList.isEmpty()){
            player.setPlayerSign('X');
        }else {
            player.setPlayerSign('O');
        }
        playerList.add(player);
    }

    void printAllPlayers(){
        for(Player p : playerList){
            System.out.println(p.getName() + " " + p.getPlayerSign());
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }
}
