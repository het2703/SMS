package UI.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sms.Users;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Button forgotpass;



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
            forgotpass.setStyle(
                    "-fx-back-ground-color:blue;"
            );

        }
        else if (!userid.getText().isBlank() && !password.getText().isBlank()) {
            boolean b =checklogin();
            if(b){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
                Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
                BorderPane pane = loader.load();
                stage.getScene().setRoot(pane);
                stage.show();
            }
            else{
                loginlabel.setText("Incorrect userId or Password !");
                forgotpass.setStyle(
                        "-fx-back-ground-color:blue;"
                );
            }
        }
        }
    @FXML
    void forgotpassbutton(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

@FXML
void signupnow(MouseEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getClassLoader().getResource("fxml/signup.fxml"));
    Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
    BorderPane pane = loader.load();
    stage.getScene().setRoot(pane);
    stage.show();
}


    @FXML
    public boolean checklogin() throws SQLException, ClassNotFoundException {
        int savedValue = Integer.parseInt(userid.getText());
        return Users.login( savedValue, password.getText());
    }
}

