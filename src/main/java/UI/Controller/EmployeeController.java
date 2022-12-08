package UI.Controller;

import Database.DAO.EmployeeDAO;
import Database.DB;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sms.Employee;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EmployeeController {

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
    private TextField searchemp;



    @FXML
    void addemployee(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/addemployee.fxml"));
        BorderPane pane = loader.load();
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(pane);
        stage.show();
    }
    @FXML
    void remove(){
        int select = tableview.getSelectionModel().getSelectedIndex();
        tableview.getItems().remove(select);
        }



    public ObservableList<Employee> datalist = FXCollections.observableArrayList();

    @FXML
    void search(){

        namecol.setCellValueFactory(new PropertyValueFactory<Employee, String>("namecol"));
        idcol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("idcol"));
        phonecol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("phonecol"));
        gendercall.setCellValueFactory(new PropertyValueFactory<Employee, String>("gendercall"));

        if (searchemp.)

        datalist.add
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