package UI.Controller;

import Database.DAO.ProfileDAO;
import UI.Elements.ConfirmBox;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sms.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private Button changepass;
    @FXML
    private Button logoutfromeditpro;
    @FXML
    private Button editprofile;
    @FXML
    private Button changepassidinedit;
    @FXML
    private Button logoutfromprofile;

    @FXML
    private Button openpro;
    @FXML
    private Button opendit_pro;

    @FXML
    private Button openprofrompass;

    @FXML
    private static Label departmentlabel;

    @FXML
    private static Label doblabel;

    @FXML
    private static Label idlabel;
    @FXML
    private static Label namelabel;

    @FXML
    private static Label phonenumberlabel;

int id1;

    public void getid(int id ) {
        id1 = id;
    }


@FXML
private Button byteme1;

    @FXML
    void opendashboard_fromprofile(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

    @FXML
    void changepasspage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/PROFILE PASSWORD.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

    @FXML
    void editprofilepage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/PROFILE EDIT.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

    @FXML
    void logout_from_profile(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?", "Confirm logout");
        if (b) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            BorderPane pane = loader.load();
            stage.getScene().setRoot(pane);
            stage.show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            idlabel.setText(String.valueOf(id1));
        });
    }
}
