import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, 320, 240));
        stage.show();
    }
//YE ek team project he (loda)
    public static void main(String[] args) {
        launch(args);
    }
}