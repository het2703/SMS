import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        stage.setTitle("Hello");
        stage.setScene(new Scene(root,1800,850));
        stage.setMaximized(true);
        stage.show();
    }
//YE ek team project he
    public static void main(String[] args) {
        launch(args);
    }
}