package UI.Controller;

import Database.DAO.ProductDAO;
import Database.DB;
import UI.Elements.ConfirmBox;
import UI.Elements.JumpScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import sms.Products;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Database.DB.size;

public class StockController implements Initializable {

    @FXML
    BorderPane stock_details_borderpane;

    @FXML
    private Button bytme;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<Products, Integer> Product_Id;

    @FXML
    private TableColumn<Products, String> Product_Name;

    @FXML
    private TableColumn<Products,Integer> Price;

    @FXML
    private TableColumn<Products,Integer> Stock;

    @FXML
    private TableView<Products> p_view;

    @FXML
    private TextField searchstock;
    @FXML
    void logoutnow(MouseEvent event) throws IOException {
        boolean b = ConfirmBox.displayAlert("Logout?","Confirm logout");
        if(b){
            JumpScene.changeScene(stock_details_borderpane,"fxml/login.fxml",event);
        }
    }

    @FXML
    void addproductnow(MouseEvent event) throws SQLException, ClassNotFoundException, IOException {
        JumpScene.changeScene(stock_details_borderpane,"fxml/addStock.fxml",event);
    }

    @FXML
    void stocktodash(MouseEvent event) throws IOException {
        JumpScene.changeScene(stock_details_borderpane,"fxml/dashboard.fxml",event);
    }

    private final ObservableList<Products> datalist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Product_Id.setCellValueFactory(new PropertyValueFactory<Products, Integer>("product_id"));
        Product_Name.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
        Price.setCellValueFactory(new PropertyValueFactory<Products, Integer>("price"));
        Stock.setCellValueFactory(new PropertyValueFactory<Products, Integer>("stock"));

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
        searchstock.textProperty().addListener((observableValue, oldValue, newValue) ->
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
        sorteddata.comparatorProperty().bind(p_view.comparatorProperty());
        p_view.setItems(sorteddata);

    }
}
