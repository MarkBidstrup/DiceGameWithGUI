package main;

public class Die {
    private int faceValue;
    private final int MAX;

    public Die () {
        faceValue = 1;
        MAX = 6;
    }

    public void roll() {
        faceValue = (int) (Math.random() * MAX) + 1;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return "" + faceValue;
    }
}
