package UI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    public void onHelloButtonClick(){
        welcomeText.setText("This is done by us");
    }
}