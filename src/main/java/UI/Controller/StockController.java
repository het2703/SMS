package UI.Controller;

import Database.DAO.EmployeeDAO;
import Database.DAO.ProductDAO;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sms.Employee;
import sms.Products;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Database.DB.size;

public class StockController implements Initializable {
    @FXML
    private Button addbutton;
    @FXML
    private TextField productid;

    @FXML
    private TextField productname;

    @FXML
    private TextField productprice;

    @FXML
    private TextField productquantity;
    @FXML
    private Label stockwarning;
    @FXML
    private Button bytme1;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<Products, Integer> product_id;

    @FXML
    private TableColumn<Products, String> p_name;

    @FXML
    private TableColumn<Products,Integer> price;

    @FXML
    private TableColumn<Products,Integer> stock;

    @FXML
    private TableView<Products> product_view;
    @FXML
    void logoutnow(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?","Confirm logout");
        if(b){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/login.fxml"));
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            BorderPane pane = loader.load();
            stage.getScene().setRoot(pane);
            stage.show();
        }
    }

    @FXML
    void addproductnow(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {

        boolean b=addstock();
        if(b){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("fxml/stock.fxml"));
            Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
            BorderPane pane = loader.load();
            stage.getScene().setRoot(pane);
            stage.show();
        }
        else if(productid.getText().isBlank() || productname.getText().isBlank() || productprice.getText().isBlank() || productquantity.getText().isBlank()){
            stockwarning.setText("Invalid details !");
        }
        else{
            stockwarning.setText("Invalid details !");
        }
    }

    @FXML
    void stocktodash(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("fxml/dashboard.fxml"));
        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        BorderPane pane = loader.load();
        stage.getScene().setRoot(pane);
        stage.show();
    }
    public boolean addstock() throws SQLException, ClassNotFoundException {

        int id=Integer.parseInt(productid.getText());
        String pname=productname.getText();
        int price=Integer.parseInt(productprice.getText());
        int stock=Integer.parseInt(productquantity.getText());
        return Products. createNewProduct(id, pname, price, stock);
    }

    private final ObservableList<Products> datalist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        product_id.setCellValueFactory(new PropertyValueFactory<Products, Integer>("product_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<Products, String>("P_name"));
        price.setCellValueFactory(new PropertyValueFactory<Products, Integer>("price"));
        stock.setCellValueFactory(new PropertyValueFactory<Products, Integer>("stock"));

        try {
            String query = "select * from products";
            ResultSet data = DB.dbExecuteQuery(query);
            assert data != null;
            int size = size(data);
            Products[] p = new Products[size];
            ProductDAO.dataToArray(data,p);
            for (int i = 0; i < p.length ; i++) {
                datalist.add(i,p[i]);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        FilteredList<Products> filtereddata = new FilteredList<>(datalist, b -> true);
        productname.textProperty().addListener((observableValue, oldValue, newValue) ->
        {
            filtereddata.setPredicate(person -> {
                if (newValue == null && newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                 else {
                    return false;
                }
            });
        });
        SortedList<Products> sorteddata = new SortedList<>(filtereddata);
        sorteddata.comparatorProperty().bind(product_view.comparatorProperty());
        product_view.setItems(sorteddata);

    }
}
