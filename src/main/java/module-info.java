module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens main to javafx.fxml;
    exports main;
}