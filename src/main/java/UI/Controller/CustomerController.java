package UI.Controller;

import Database.DAO.CustomerDAO;
import Database.DB;
import UI.Elements.ConfirmBox;
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
import sms.Customer;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Database.DB.size;

public class CustomerController implements Initializable {

    @FXML
    private BorderPane custPane;
    @FXML
    private Button addcustomerbutton;

    @FXML
    private Button back;

    @FXML
    private Button dashboard1;
    @FXML
    private TableColumn<Customer, Integer> idcolumn;

    @FXML
    private TableColumn<Customer, String> namecolumn;

    @FXML
    private TableColumn<Customer, Integer> phonenumbercolumn;

    @FXML
    private TableColumn<Customer,Integer> expcolumn;
    @FXML
    private TextField searchtext;

    @FXML
    private TableView<Customer> customerview;


    @FXML
    void addcustomer(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/addcustomer.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

    @FXML
    void logoutnow(MouseEvent event) throws IOException {
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

    @FXML
    void opendashboard(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }

    private final ObservableList<Customer> datalist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        namecolumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("first_name"));
        idcolumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customer_id"));
        phonenumbercolumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("phone_number"));
        expcolumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("expenditure"));


        try {
            String query = "select * from customer";
            ResultSet data = DB.dbExecuteQuery(query);
            assert data != null;
            int size = size(data);
            Customer[] cus = new Customer[size];
            CustomerDAO.dataToArray(data,cus);
            for (int i = 0; i < cus.length ; i++) {
                datalist.add(i,cus[i]);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        FilteredList<Customer> filtereddata = new FilteredList<>(datalist, b -> true);
        searchtext.textProperty().addListener((observableValue, oldValue, newValue) ->
        {
            filtereddata.setPredicate(person -> {
                if (newValue == null && newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getFname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                 else {
                    return false;
                }
            });
        });
        SortedList<Customer> sorteddata = new SortedList<>(filtereddata);
        sorteddata.comparatorProperty().bind(customerview.comparatorProperty());
        customerview.setItems(sorteddata);

    }
}
