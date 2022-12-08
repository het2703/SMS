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
import sms.Employee;

import java.io.IOException;
import java.sql.SQLException;
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
    private Label warninglabel;
    @FXML
    private TextField phonenumber;

    @FXML
    private TextField salary;
    @FXML
    private TextField empid;
    @FXML
    void addnow(MouseEvent event) throws ParseException, SQLException, ClassNotFoundException, IOException {
      boolean b= checkcred();
      if(b){
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getClassLoader().getResource("fxml/Employee.fxml"));
          Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
          BorderPane pane = loader.load();
          stage.getScene().setRoot(pane);
          stage.show();
      }
      else{
         warninglabel.setText("Invalid Credentials !");
      }
    }

    @FXML
    void cancelnow(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/Employee.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }
    public boolean checkcred() throws ParseException, SQLException, ClassNotFoundException {
        int empid1= Integer.parseInt(empid.getText());
        java.sql.Date dob1 = (java.sql.Date) new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH).parse(dob.getText());
        java.sql.Date hiredate1 = (java.sql.Date) new SimpleDateFormat("YYYY-MM-DD", Locale.ENGLISH).parse(hiredate.getText());
        String email1=email.getText();
        String firstn=firstname.getText();
        String gender1=gender.getText();
        String lastn=lastname.getText();
        long phonenumber1 = Long.parseLong(phonenumber.getText());
        int salary1=Integer.parseInt(salary.getText());
        return Employee.createNewEmployee(empid1, firstn, lastn, email1,phonenumber1, hiredate1, dob1, gender1, salary1);
    }

}
