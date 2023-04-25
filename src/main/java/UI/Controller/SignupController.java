package UI.Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Users;

public class SignupController {

    public Button loginagain;
    public TextField newdate;
    public TextField newphonenumber;
    public Button signup;
    @FXML
    private BorderPane signupPane;
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
        JumpScene.changeScene(signupPane,"fxml/login.fxml",event);
    }
    @FXML
    void validatesignup(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        boolean a= checksignup();
        if(a){
            JumpScene.changeScene(signupPane,"fxml/login.fxml",event);
        }
        else {
            signuplabel.setText("Enter your credential !");
        }
    }

    public boolean checksignup() throws SQLException, ClassNotFoundException {
        int newid = Integer.parseInt(newuserid.getText());
        long phone = Long.parseLong(newphonenumber.getText());
        Date date = Date.valueOf(newdate.getText());
       String s="";
        if(Admin.isSelected()){
           s="ADMIN";
        }
        else if (Cashier.isSelected()) {
        s="CASHIER";
        }

       return Users.createNewUser(newid,newname.getText(),s,phone,date,newpassword.getText());
    }
}
