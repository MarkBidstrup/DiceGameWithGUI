package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GameController {
    @FXML
    ImageView die1Image;

    @FXML
    ImageView die2Image;

    @FXML
    Button rollButton;

    @FXML
    TextField PlayerOnePoints;

    @FXML
    TextField PlayerTwoPoints;

    @FXML
    VBox p1box;

    @FXML
    VBox p2box;

    @FXML
    Label label;

    // Dice files
    Game game = new Game("Mark", "Hej");

    FileInputStream inputstream1 = new FileInputStream("C:\\Users\\markb\\OneDrive\\IntelliJ_Projects\\javafx\\src\\main\\java\\main\\1.png");
    Image die1 = new Image(inputstream1);
    FileInputStream inputstream2 = new FileInputStream("C:\\Users\\markb\\OneDrive\\IntelliJ_Projects\\javafx\\src\\main\\java\\main\\1.png");
    Image die2 = new Image(inputstream2);
    FileInputStream inputstream3 = new FileInputStream("C:\\Users\\markb\\OneDrive\\IntelliJ_Projects\\javafx\\src\\main\\java\\main\\3.png");
    Image die3 = new Image(inputstream3);
    FileInputStream inputstream4 = new FileInputStream("C:\\Users\\markb\\OneDrive\\IntelliJ_Projects\\javafx\\src\\main\\java\\main\\4.png");
    Image die4 = new Image(inputstream4);
    FileInputStream inputstream5 = new FileInputStream("C:\\Users\\markb\\OneDrive\\IntelliJ_Projects\\javafx\\src\\main\\java\\main\\5.png");
    Image die5 = new Image(inputstream5);
    FileInputStream inputstream6 = new FileInputStream("C:\\Users\\markb\\OneDrive\\IntelliJ_Projects\\javafx\\src\\main\\java\\main\\6.png");
    Image die6 = new Image(inputstream6);

    Image imageArray[] = {die1, die2, die3, die4, die5, die6};

    public GameController() throws FileNotFoundException {
    }

    public void initialize () {
        updateViews();
        label.setText("Dice Game");
        rollButton.setText("Roll");
        rollButton.setOnAction(event -> roll());
    }

    public void updateViews() {
        if (game.gameOver() && (game.getP1().getScore() > game.getP2().getScore())) {
            p1box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
            p2box.setBackground(null);
            PlayerOnePoints.setText("" + game.getP1().getScore());
            rollButton.setText("Reset");
            label.setText("Player 1 wins!");
            rollButton.setOnAction(event -> resetGame());
        }
        if (game.gameOver() && (game.getP1().getScore() < game.getP2().getScore())) {
            p2box.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
            p1box.setBackground(null);
            PlayerTwoPoints.setText("" + game.getP2().getScore());
            rollButton.setText("Reset");
            label.setText("Player 2 wins!");
            rollButton.setOnAction(event -> resetGame());
        }
        if (!game.gameOver()) {
            label.setText("Reach 40 points to win");
            PlayerOnePoints.setText("" + game.getP1().getScore());
            PlayerTwoPoints.setText("" + game.getP2().getScore());
        }

    }
    public void roll() {
        updateViews();
        game.roll();
        die1Image.setImage(imageArray[game.getD1().getFaceValue()-1]);
        die2Image.setImage(imageArray[game.getD2().getFaceValue()-1]);
        updateViews();
    }

    public void resetGame() {
        game.getP1().resetGame();
        game.getP2().resetGame();
        p1box.setBackground(null);
        p2box.setBackground(null);
        updateViews();
        label.setText("Dice Game");
        rollButton.setText("Start Game");
        rollButton.setOnAction(event -> initialize());
    }
}