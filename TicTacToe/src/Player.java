public class Player {
    private String name;
    private char playerSign;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getPlayerSign() {
        return (char)playerSign;
    }

    public void setPlayerSign(char playerSign) {
        this.playerSign = playerSign;
    }

}
