package UI.Controller;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sms.Users;
import java.io.IOException;
import java.sql.SQLException;
import java.util.EventObject;
import javafx.scene.control.Label;
public class SignupController {

    @FXML
    private Button login11button;

    @FXML
    private Button login12;

    @FXML
    private Label signuplabel;

    @FXML
    private TextField newname;
@FXML
private RadioButton Admin;
@FXML
private RadioButton Cashier;
    @FXML
    private PasswordField newpassword;

    @FXML
    private TextField newuserid;

    @FXML
    void loginagain(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/login.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }
    @FXML
    void validatesignup(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        boolean a= checksignup();
        if(a){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/login.fxml"));
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            BorderPane pane = loader.load();
            stage.getScene().setRoot(pane);
            stage.show();
        }
        else {
            signuplabel.setText("Enter your credential !");
        }
    }


    public boolean checksignup() throws SQLException, ClassNotFoundException {
        int newid = Integer.parseInt(newuserid.getText());
       String s="";
        if(Admin.isSelected()){
           s="ADMIN";
        }
        else if (Cashier.isSelected()) {
        s="CASHIER";
        }

       return Users.createNewUser(newid,newname.getText(),s,newpassword.getText());
    }

}
