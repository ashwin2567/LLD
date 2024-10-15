public class BoardManager {
    void printBoard(Board b){
        char[][] board = b.getBoard();
        // System.out.println("####");
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isGameWon(Board b){
        char[][] board = b.getBoard();
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return true;
            }

            if (board[0][i] != '-' &&
                    board[0][i] == board[1][i] &&
                    board[1][i] == board[2][i]) {
                return true;
            }
        }

        if (board[1][1] != '-') {
            if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
                    (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
                return true;
            }
        }

        return false;
    }

    boolean isGameDraw(Board b){
        char[][] board = b.getBoard();
        for(int i=0;i<board.length;i++){
            for(int j=0;j< board.length;j++){
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isPositionValid(String rowVal, String colVal, Board b){
        int i = Integer.parseInt(rowVal);
        int j = Integer.parseInt(colVal);
        char[][] board = b.getBoard();
        return i >=0 && j >= 0 && i < board.length && j < board.length && board[Integer.parseInt(rowVal)][Integer.parseInt(colVal)] == '-';
    }
}
