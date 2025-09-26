import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public abstract class Game implements Playable{
    private String gameName;
    private int gameID;
    private double requiredBet;
    private boolean gameStarted;
    private boolean isAssigned = false;

    private static final Random rand = new Random();
    private static final List<Integer> usedGameIDs = new ArrayList<>();
    private static int counter = 0;

    public Game (String gameName, double requiredBet) {
        this.gameName = gameName;
        this.requiredBet = requiredBet;
        this.gameStarted = false;
    }

    public abstract String getName();

    public abstract double getRequiredBet();

    public int getGameID() {
        return gameID;
    }
    public void setGameID() {
        if (isAssigned) {
            throw new UnsupportedOperationException("Game ID is set. No further changes allowed");
        }
        boolean uniqueGameID = false;
        while (!uniqueGameID) {
            int ID = 10000 + rand.nextInt(90000);
            uniqueGameID = true;
            for (int i = 0; i < counter; i++) {
                if (usedGameIDs[i] = ID) {
                    uniqueGameID = false;
                    break;
                }
            }
        }
        usedGameIDs[counter++] = ID;
        this.gameID = ID;
    }

    public boolean gameStarted() {
        return gameStarted;
    }
    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    @Override
    public String toString() {
        return "Game Name: " + gameName + "\nGame ID: " + gameID + "\nRequired Bet: $" + requiredBet;
    }
}
