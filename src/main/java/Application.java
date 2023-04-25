import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("M3:MyMarketManagement");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
//YE ek team project he
    public static void main(String[] args) {
        launch(args);
    }
}