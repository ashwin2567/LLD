import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world, Play Snake and Ladder");
        //Scanner sc = new Scanner(System.in);
        String filePath = "/Users/imashwin/Desktop/playground/SnakeLadder/src/inp.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        SnakeManager snakeManager = SnakeManager.getSnakeManager();
        LadderManager ladderManager = LadderManager.getLadderManager();
        PlayerManager playerManager = new PlayerManager();
        try{

            int input = Integer.parseInt(br.readLine());
            for(int i=0;i<input;i++){
                String snakeInput = br.readLine();
                String[] inputArr = snakeInput.trim().split(" ");
                snakeManager.getSnakeMap().put(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
            }

            input = Integer.parseInt(br.readLine());
            for(int i=0;i<input;i++){
                String ladderInput = br.readLine();
                String[] inputArr = ladderInput.trim().split(" ");
                ladderManager.getLadderMap().put(Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]));
            }

            input = Integer.parseInt(br.readLine());
            for(int i=0;i<input;i++){
                String playerName = br.readLine();
                playerManager.getPlayerList().add(new Player(playerName));
            }


            int curr = 0;
            List<Player> playerList = playerManager.getPlayerList();
            while(playerManager.toContinue()){
                Player p = playerList.get(curr % 2);
                int randomNumber = playerManager.getRandom();
                p.setCurr_position(randomNumber);
                curr++;
                p.setPrev_position(p.getCurr_position());
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}