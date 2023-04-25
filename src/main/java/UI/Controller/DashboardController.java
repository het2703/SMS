package UI.Controller;

import UI.Elements.ConfirmBox;
import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class DashboardController {

    @FXML
    private BorderPane dashPane;
    @FXML
    private Button stockbutton;

    @FXML
    private Button employeedetails;

    @FXML
    private Button profilebutton;

    @FXML
    private Button logoutdash;
    @FXML
    void logoutnow(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?","Confirm logout");
        if(b){
            JumpScene.changeScene(dashPane,"fxml/login.fxml",event);
        }
    }

    @FXML
    void openprofile(MouseEvent event) throws IOException {
        JumpScene.changeScene(dashPane,"fxml/profile1.fxml",event);
    }
    @FXML
    void employeeinfo(MouseEvent event) throws IOException {
        JumpScene.changeScene(dashPane,"fxml/Employee.fxml",event);
    }

    @FXML
    void customerdetailsopen(MouseEvent event) throws IOException {
        JumpScene.changeScene(dashPane,"fxml/Customer.fxml",event);
    }
    @FXML
    void stockdetails(MouseEvent event) throws IOException {
        JumpScene.changeScene(dashPane,"fxml/Stock1.fxml",event);
    }
}