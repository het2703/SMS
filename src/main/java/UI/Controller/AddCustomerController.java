package UI.Controller;

import UI.Elements.ConfirmBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustomerController {
    @FXML
    private Button addconsumerbutton;

    @FXML
    private Button back;

    @FXML
    private Button cancelbutton;

    @FXML
    private TextField email1;

    @FXML
    private TextField expenditure;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private Button logout;

    @FXML
    private TextField phonenumber;

    @FXML
    void addconsumer(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }


    @FXML
    void canceltodashboard(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

}

