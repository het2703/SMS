package UI.Controller;

import Profile.CurrentUserInfo;
import UI.Elements.ConfirmBox;
import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChangePasswordController implements Initializable {

    public Button conf;
    @FXML
    private Label label;
    @FXML
    private BorderPane pass;
    @FXML
    private Button byteme2;
    @FXML
    private TextField conp;
    @FXML
    private TextField cp;
    @FXML
    private TextField np;
    @FXML
    private Button logoutfrompass;
    @FXML
    private Button openprofrompass;
    @FXML
    void opendash_frompass(MouseEvent event) throws IOException {
        JumpScene.changeScene(pass,"fxml/dashboard.fxml",event);
    }

    @FXML
    void open_profile_frompass(MouseEvent event) throws IOException {
        JumpScene.changeScene(pass,"fxml/PROFILE.fxml",event);
    }

    @FXML
    void logout_from_pass(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?", "Confirm logout");
        if (b) {
            JumpScene.changeScene(pass,"fxml/login.fxml",event);
        }
    }

    @FXML
    void changepass() throws SQLException {
        if (Objects.equals(cp.getText(), CurrentUserInfo.getUser().getPassword())){
            if (Objects.equals(np.getText(), conp.getText())){
                Users.changePassword(CurrentUserInfo.getUser().getStaff_id(), conp.getText());
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        label.setText(CurrentUserInfo.getUser().getName());
    }
}