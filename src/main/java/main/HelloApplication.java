package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, 106, 26));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}