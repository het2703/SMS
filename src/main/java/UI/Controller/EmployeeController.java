package UI.Controller;

import Database.DAO.EmployeeDAO;
import Database.DB;
import UI.Elements.ConfirmBox;
import UI.Elements.JumpScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Database.DB.size;

public class EmployeeController implements Initializable {

    public Button bytme;
    public Button lout;
    @FXML
    private BorderPane empPane;
    @FXML
    private Button addbutton;
    @FXML
    private TableView<Employee> tableview;
    @FXML
    private TableColumn<Employee, String> gendercall;

    @FXML
    private TableColumn<Employee, Integer> idcol;

    @FXML
    private TableColumn<Employee, String> namecol;

    @FXML
    private TableColumn<Employee, Integer> phonecol;

    @FXML
    private TableColumn<Employee,String> emailcol;
    @FXML
    private TextField searchemp;


    @FXML
    void logoutnow(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?","Confirm logout");
        if(b){
            JumpScene.changeScene(empPane,"fxml/login.fxml",event);
        }
    }
    @FXML
    void gottodash(MouseEvent event) throws IOException {
        JumpScene.changeScene(empPane,"fxml/dashboard.fxml",event);
}

    @FXML
    void addemployee(MouseEvent event) throws IOException {
        JumpScene.changeScene(empPane,"fxml/addemployee.fxml",event);
    }
    private final ObservableList<Employee> datalist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        namecol.setCellValueFactory(new PropertyValueFactory<Employee, String>("first_name"));
        idcol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employee_id"));
        phonecol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("phone_number"));
        gendercall.setCellValueFactory(new PropertyValueFactory<Employee, String>("gender"));
        emailcol.setCellValueFactory(new PropertyValueFactory<Employee,String>("email"));

        try {
            String query = "select * from employee";
            ResultSet data = DB.dbExecuteQuery(query);
            assert data != null;
            int size = size(data);
            Employee[] emp = new Employee[size];
            EmployeeDAO.dataToArray(data,emp);
            for (int i = 0; i < emp.length ; i++) {
                datalist.add(i,emp[i]);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        FilteredList<Employee> filtereddata = new FilteredList<>(datalist, b -> true);
        searchemp.textProperty().addListener((observableValue, oldValue, newValue) ->
        {
            filtereddata.setPredicate(person -> {
                if (newValue == null && newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getFirst_name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (person.getGender().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<Employee> sorteddata = new SortedList<>(filtereddata);
        sorteddata.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sorteddata);

    }
}