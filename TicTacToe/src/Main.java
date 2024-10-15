import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        final int boardSize = 3;
        BoardManager boardManager = new BoardManager();
        PlayerManager playerManager  = new PlayerManager();
        playerManager.addPlayer(new Player("Ashwin"));
        playerManager.addPlayer(new Player("Ankit"));
        playerManager.printAllPlayers();

        Board board = new Board(boardSize);
        boardManager.printBoard(board);

        Scanner sc = new Scanner(System.in);
        List<Player> playerList = playerManager.getPlayerList();
        int currentTurn = 0;
        while(true){
            Player p = playerList.get(currentTurn%2);
            System.out.println("Its " + p.getName()  + "'s turn, pls enter your position");
            String input = sc.nextLine();
            input = input.trim();
            String inpArr[] = input.split(" ");
            if(inpArr.length == 2) {
                if (boardManager.isPositionValid(inpArr[0], inpArr[1], board)) {
                    board.setBoard(Integer.parseInt(inpArr[0]), Integer.parseInt(inpArr[1]), p.getPlayerSign());
                    boardManager.printBoard(board);
                } else {
                    System.out.println("Invalid Position");
                    currentTurn--;
                }
                currentTurn++;
                if (boardManager.isGameWon(board)) {
                    System.out.println(p.getName() + " won the game.");
                    break;
                }
                else if ((boardManager.isGameDraw(board))){
                    System.out.println("No more moves left. Game Draw!!");
                    break;
                }
            }
            else{
                System.out.println("Invalid Input");
                break;
            }
        }

    }

}