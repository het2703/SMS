package UI.Elements;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
public class JumpScene {
    public static void changeScene(BorderPane pane, String fxmlLocation, ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(JumpScene.class.getClassLoader().getResource(fxmlLocation));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

    public static void changeScene(BorderPane pane, String fxmlLocation, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(JumpScene.class.getClassLoader().getResource(fxmlLocation));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }
}
