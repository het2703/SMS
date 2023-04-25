package UI.Controller;

import UI.Elements.JumpScene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Employee;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class AddEmployeeController {

    @FXML
    private BorderPane nePane;
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
    void addnow(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
      boolean b= checkcred();
      if(b){
          JumpScene.changeScene(nePane,"fxml/Employee.fxml",event);
      }
      else{
         warninglabel.setText("Invalid Credentials !");
      }
    }

    @FXML
    void cancelnow(MouseEvent event) throws IOException {
        JumpScene.changeScene(nePane,"fxml/Employee.fxml",event);
    }
    public boolean checkcred() throws SQLException, ClassNotFoundException {
        int empid1= Integer.parseInt(empid.getText());
        Date dob1 = Date.valueOf(dob.getText());
        Date hiredate1 = Date.valueOf(hiredate.getText());
        String email1=email.getText();
        String firstn=firstname.getText();
        String gender1=gender.getText();
        String lastn=lastname.getText();
        long phonenumber1 = Long.parseLong(phonenumber.getText());
        int salary1=Integer.parseInt(salary.getText());
        return Employee.createNewEmployee(empid1, firstn, lastn, email1,phonenumber1, hiredate1, dob1, gender1, salary1);
    }
}
