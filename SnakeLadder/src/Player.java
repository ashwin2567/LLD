import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private int curr_position;
    private int prev_position;

    public Player(String name) {
        this.name = name;
        curr_position = 0;
        prev_position = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurr_position() {
        return curr_position;
    }

    public int  getPrev_position() {
        return prev_position;
    }

    public void setCurr_position(int diceValue) {
        int nextPos = diceValue + prev_position;
        SnakeManager snakeManager = SnakeManager.getSnakeManager();
        Map<Integer, Integer> snakeMap = snakeManager.getSnakeMap();
        LadderManager ladderManager = LadderManager.getLadderManager();
        Map<Integer, Integer> ladderMap = ladderManager.getLadderMap();
        if(ladderMap.containsKey(nextPos)){
            this.curr_position = ladderMap.get(nextPos);
            System.out.println(this.getName() + " rolled a dice value " + diceValue + " and moved from " + this.getPrev_position() +"(" + nextPos + ")to " + this.getCurr_position() + " using ladder.");
            //System.out.println(this.name +" climbed up ladder to " + this.curr_position);
        } else if (snakeMap.containsKey(nextPos)) {
            this.curr_position = snakeMap.get(nextPos);
            //System.out.println(this.name + " bit by snake to " + this.curr_position);
            System.out.println(this.getName() + " rolled a dice value " + diceValue + " and moved from " + this.getPrev_position() +"(" + nextPos + ")to " + this.getCurr_position() + " because of snake bite");
        }
        else if(nextPos <= 100){
            this.curr_position = nextPos;
            System.out.println(this.getName() + " rolled a dice value " + diceValue + " and moved from " + this.getPrev_position() +" to " + this.getCurr_position());
        }
        // dont update if does not fall in any 3
    }

    public void setPrev_position(int prev_position) {
        this.prev_position = prev_position;
    }
}
