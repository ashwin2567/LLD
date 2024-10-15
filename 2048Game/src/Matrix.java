import java.util.*;

public class Matrix {
    final int boardSize = 4;
    List<List<Integer>> board;
    Random random = new Random();
    Matrix(){
        board = new ArrayList<>(4);
        board.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        board.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        board.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        board.add(new ArrayList<>(Arrays.asList(0,0,0,0)));
        int i1 = random.nextInt(4);
        int j1 = random.nextInt(4);
        int i2 = random.nextInt(4);
        int j2 = random.nextInt(4);
        board.get(i1).set(j1, 2);
        board.get(i2).set(j2, 2);
    }

    void printBoard(){
        System.out.println("######");
        for(int i=0;i<board.size();i++){
            System.out.print(("| "));
            for(int j=0;j<board.get(0).size();j++){
                System.out.print(board.get(i).get(j) + " |");
            }
            System.out.println();
        }
    }

    private List<Integer> mergeOneRowLeft(List<Integer> row){
        for(int j=0;j<boardSize-1;j++) {
            for (int i = boardSize - 1; i > 0; i--) {
                if (row.get(i - 1) == 0) {
                    row.set(i - 1, row.get(i));
                    row.set(i, 0);
                }
            }
        }
        for(int i=0;i<boardSize-1;i++) {
            if (Objects.equals(row.get(i), row.get(i + 1))) {
                row.set(i, row.get(i) * 2);
                row.set(i+1, 0);
            }
        }

        for (int i = boardSize - 1; i > 0; i--) {
            if (row.get(i - 1) == 0) {
                row.set(i - 1, row.get(i));
                row.set(i, 0);
            }
        }
        return row;
    }

    void mergeLeft(){
        for(int i=0;i<boardSize;i++){
            board.set(i, mergeOneRowLeft(board.get(i)));
        }
    }

    void mergeRight(){
        for(int i=0;i<boardSize;i++){
            Collections.reverse(board.get(i));
            Collections.reverse(mergeOneRowLeft(board.get(i)));
        }
    }

    void mergeUp(){
        board = transpose(board);
        mergeLeft();
        board = transpose(board);
    }

    void mergeDown(){
        board = transpose(board);
        mergeRight();
        board = transpose(board);
    }

    List<List<Integer>> transpose(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.getFirst().size();
        List<List<Integer>> transposed = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            List<Integer> newRow = new ArrayList<>();
            for (int j = 0; j < rows; j++) {
                newRow.add(matrix.get(j).get(i));
            }
            transposed.add(newRow);
        }
        return transposed;
    }

    boolean gameWon() {
        for (List<Integer> list : board) {
            if(list.contains(16))
                return true;
        }
        return false;
    }
    boolean gameLost() {
        for (List<Integer> list : board) {
            if(list.contains(0))
                return false;
        }
        return true;
    }

    void fillRandom(){
        int i = random.nextInt(4);
        int j = random.nextInt(4);
        while(board.get(i).get(j) != 0){
            i = random.nextInt(4);
            j = random.nextInt(4);
        }
        board.get(i).set(j, 2);
    }
}