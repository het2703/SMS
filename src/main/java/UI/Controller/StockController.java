package UI.Controller;

import UI.Elements.ConfirmBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sms.Products;

import java.io.IOException;
import java.sql.SQLException;

public class StockController {
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
}
