package UI.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import sms.Employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    @FXML
    private Button addbutton;

    @FXML
    private TextField addemp;
    @FXML
    private TableView<Employee> tableview;
    @FXML
    private TableColumn<Employee, String> gendercall;

    @FXML
    private TableColumn<Employee, Long> idcol;

    @FXML
    private TableColumn<Employee, String> namecol;

    @FXML
    private TableColumn<Employee, Long> phonecol;

    @FXML
    private Button searchbutton;

    @FXML
    private TextField searchemp;

    public EmployeeController() throws IOException {
    }

    @FXML
    void addemployee(MouseEvent event) {

    }
@FXML
void remove(){
        int select = tableview.getSelectionModel().getSelectedIndex();
        tableview.getItems().remove(select);
}

    @FXML
    void searchemployee(MouseEvent event) {

    }
    ObservableList<Employee> datalist = FXCollections.observableArrayList();

    @FXML
    void search(){
        namecol.setCellValueFactory(new PropertyValueFactory<Employee, String>("namecol"));
        idcol.setCellValueFactory(new PropertyValueFactory<Employee, Long>("idcol"));
        phonecol.setCellValueFactory(new PropertyValueFactory<Employee, Long>("phonecol"));
        gendercall.setCellValueFactory(new PropertyValueFactory<Employee, String>("gendercall"));


//        datalist=//connect.getusersdata()

        tableview.setItems(datalist);
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    search();

    }
}