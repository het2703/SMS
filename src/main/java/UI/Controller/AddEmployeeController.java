package UI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddEmployeeController {
    @FXML
    private Button addbutton1;

    @FXML
    private Button cancelbutton1;

    @FXML
    private TextField dob;

    @FXML
    private TextField email;

    @FXML
    private TextField firstname;

    @FXML
    private TextField gender;

    @FXML
    private TextField hiredate;

    @FXML
    private TextField lastname;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField salary;


    void createnewemployee() throws ParseException {
        Date dob1 = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH).parse(dob.toString());
       Date hiredate1 = new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH).parse(hiredate.toString());
        String email1=email.getText();
        String firstn=firstname.getText();
        String gender1=gender.getText();
        String lastn=lastname.getText();
        long phonenumber1 = Long.parseLong(phonenumber.getText());
        int salary1=Integer.parseInt(salary.getText());
    }
    @FXML
    void addnow(MouseEvent event) {

    }

    @FXML
    void cancelnow(MouseEvent event) {

    }

}
