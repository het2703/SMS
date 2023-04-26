package UI.Controller;

import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import sms.Users;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private BorderPane loginPane;

    @FXML
    private Label loginlabel;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userid;

    @FXML
    void loginnow(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        if (userid.getText().isBlank() && password.getText().isBlank()) {
            loginlabel.setText("Try to login !");
        }

        else if (!userid.getText().isBlank() && !password.getText().isBlank()) {
            boolean b =checklogin();
            if(b){
                JumpScene.changeScene(loginPane,"fxml/dashboard.fxml",event);
            }
            else{
                loginlabel.setText("Incorrect userId or Password !");
            }
        }
    }

    @FXML
    void signupnow(MouseEvent event) throws IOException {
        JumpScene.changeScene(loginPane,"fxml/signup.fxml",event);
    }
    @FXML
    public boolean checklogin() throws SQLException, ClassNotFoundException {
        int savedValue = Integer.parseInt(userid.getText());
        return Users.login( savedValue, password.getText());
    }
}
