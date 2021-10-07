package main;

public class Game {

    public static final int MAX_SCORE = 40;

    // Data Fields
    private Die d1, d2;
    private Player p1;
    private Player p2;
    private Player currentPlayer;

    // Constructor
    public Game(String p1name, String p2name) {
        d1 = new Die();
        d2 = new Die();
        p1 = new Player(p1name);
        p2 = new Player(p2name);
        currentPlayer = p1;
    }

    public Die getD1() {
        return d1;
    }

    public Die getD2() {
        return d2;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean gameOver() {
        return (p1.getScore() >= MAX_SCORE) || (p2.getScore() >= MAX_SCORE);
    }

    public boolean p1Turn() {
        return currentPlayer == p1;
    }

    public void switchTurn() {
        if (p1Turn()) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
    }

    public void roll() {
        d1.roll();
        d2.roll();
        int faceValue1 = d1.getFaceValue();
        int faceValue2 = d2.getFaceValue();
        currentPlayer.updateTurn(faceValue1+faceValue2);
        switchTurn();
    }
}