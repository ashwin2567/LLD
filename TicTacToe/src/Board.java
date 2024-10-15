public class Board {
    public char board[][];

    Board(int x){
        board = new char[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = '-';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int i, int j, char c) {
        this.board[i][j] = c;
    }
}
