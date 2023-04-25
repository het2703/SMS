package UI.Controller;

import UI.Elements.ConfirmBox;
import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class CustomerController {

    @FXML
    private BorderPane custPane;
    @FXML
    private Button addcustomerbutton;

    @FXML
    private Button back;

    @FXML
    private Button dashboard1;
    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> gendercolumn;

    @FXML
    private TableColumn<?, ?> idcolumn;

    @FXML
    private TableColumn<?, ?> namecolumn;

    @FXML
    private TableColumn<?, ?> phonenumbercolumn;

    @FXML
    private TextField searchtext;

    @FXML
    void addcustomer(MouseEvent event) throws IOException {
        JumpScene.changeScene(custPane, "fxml/addcustomer.fxml",event);
    }

    @FXML
    void logoutnow(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?", "Confirm logout");
        if (b) {
            JumpScene.changeScene(custPane,"fxml/login.fxml",event);
        }
    }

    @FXML
    void opendashboard(MouseEvent event) throws IOException {
        JumpScene.changeScene(custPane,"fxml/dashboard.fxml",event);
    }
}
