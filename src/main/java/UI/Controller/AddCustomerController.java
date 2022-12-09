package UI.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sms.Customer;

import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerController {
    @FXML
    private Button addconsumerbutton;

    @FXML
    private Button back;
    @FXML
    private Label customerlabel;
    @FXML
    private Button cancelbutton;


    @FXML
    private TextField customerid;

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
    void addconsumer(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        boolean b = checkcustomer();
        if (b) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/Customer.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            BorderPane pane = loader.load();
            stage.getScene().setRoot(pane);
            stage.show();
        }
        else {
            customerlabel.setText("Invalid Credentials !");
        }
    }


    @FXML
    void canceltocustomer(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/Customer.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }
    public boolean checkcustomer() throws SQLException, ClassNotFoundException {
        String lname1 = lname.getText();
        String fname1 = fname.getText();
        int id1 = Integer.parseInt(customerid.getText());
        long contact=Long.parseLong(phonenumber.getText());
        int exp=Integer.parseInt(expenditure.getText());
        return Customer. createNewCustomer( id1,  fname1,  lname1,contact, exp);
    }
}

