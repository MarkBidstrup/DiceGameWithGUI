package main;

public class Player {
    // Data Fields
    private String name;
    private int score;


    // Constructor
    public Player(String name) {
        this.name = name;
        score = 0;
    }

    // Accessor Methods
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    // Game Play Methods
    public void resetGame() {
        score = 0;
    }

    public void updateTurn(int roll) {
        score += roll;
    }
}
