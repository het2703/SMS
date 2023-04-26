package UI.Controller;

import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Customer;

import java.io.IOException;
import java.sql.SQLException;

public class AddCustomerController {

    @FXML
    BorderPane ncPane;
    @FXML
    private Button addcustomerbutton;
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
    private TextField phonenumber;

    @FXML
    void addcustomer(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
        boolean b = checkcustomer();
        if (b) {
            JumpScene.changeScene(ncPane,"fxml/Customer.fxml",event);
        }
        else {
            customerlabel.setText("Invalid Credentials !");
        }
    }

    @FXML
    void canceltocustomer(MouseEvent event) throws IOException {
        JumpScene.changeScene(ncPane,"fxml/Customer.fxml",event);
    }
    public boolean checkcustomer() throws SQLException, ClassNotFoundException {
        String lname1 = lname.getText();
        String fname1 = fname.getText();
        int id1 = Integer.parseInt(customerid.getText());
        long contact=Long.parseLong(phonenumber.getText());
        int exp=Integer.parseInt(expenditure.getText());
        return Customer.createNewCustomer(id1, fname1, lname1, contact, exp);
    }
}

