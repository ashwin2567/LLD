import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int boardSize= 4;
        System.out.println("Hello world!");
        Matrix matrix = new Matrix();
        matrix.printBoard();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter direction:");
            String input = sc.nextLine();
            switch (input) {
                case "U":
                    matrix.mergeUp();
                    break;
                case "D":
                    matrix.mergeDown();
                    break;
                case "L":
                    matrix.mergeLeft();
                    break;
                case "R":
                    matrix.mergeRight();
                    break;
                default:
                    System.out.println("Invalid input");
            }
            if(matrix.gameWon()){
                System.out.println("You Won!!");
                matrix.printBoard();
                break;
            }
            else if(matrix.gameLost()){
                System.out.println("You Lost, No more moves left");
                matrix.printBoard();
                break;
            }
            matrix.fillRandom();
            matrix.printBoard();
        }
    }
}