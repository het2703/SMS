package UI.Controller;

import Profile.CurrentUserInfo;
import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private ChoiceBox<String> dep;
    @FXML
    private TextField id;
    @FXML
    private TextField dob;
    @FXML
    private TextField contact;
    @FXML
    private BorderPane profilePane;
    @FXML
    private Button byteme;
    @FXML
    private Button changepass;
    @FXML
    private Button logoutfromprofile;

    @FXML
    void backtodash(MouseEvent event) throws IOException {
        JumpScene.changeScene(profilePane,"fxml/dashboard.fxml",event);
    }

    @FXML
    void changepasspage(MouseEvent event) throws IOException {
        JumpScene.changeScene(profilePane,"fxml/PROFILE PASSWORD.fxml",event);
    }

    @FXML
    void logoutnow(MouseEvent event) throws IOException {
        JumpScene.changeScene(profilePane,"fxml/login.fxml",event);
    }

    private void setDept(){
        String[] dept= {"ADMIN","CASHIER"};
        dep.getItems().addAll(dept);
        dep.setValue(CurrentUserInfo.getUser().getDepartment());
    }

    @FXML
    void saveChanges(MouseEvent event) throws SQLException, ClassNotFoundException {
        String fname = name.getText();
        Date DOB= Date.valueOf(dob.getText());
        Long phone = Long.valueOf(contact.getText());
        Users user = new Users(CurrentUserInfo.getUser().getStaff_id(),fname,phone,DOB,CurrentUserInfo.getUser().getDepartment());
        Users.editAccountDetails(user);
        CurrentUserInfo.setUser(user);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setEditable(true);
        id.setEditable(true);
        dob.setEditable(true);
        contact.setEditable(true);

        name.setText(CurrentUserInfo.getUser().getName());
        id.setText(String.valueOf(CurrentUserInfo.getUser().getStaff_id()));
        dob.setText(String.valueOf(CurrentUserInfo.getUser().getDate_of_birth()));
        contact.setText(String.valueOf(CurrentUserInfo.getUser().getContact()));
        setDept();
    }

}
