package UI.Controller;


import UI.Elements.JumpScene;
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


public class AddStockController {
        @FXML
        private Button add_button_stock;

        @FXML
        private TextField add_price;

        @FXML
        private TextField add_product_id;

        @FXML
        private TextField add_product_name;

        @FXML
        private TextField add_quantity;

        @FXML
        private BorderPane add_stock_product;

        @FXML
        private Button cancel_button_stock;

        @FXML
        private Label warninglabel;

        @FXML
        void addnow(MouseEvent event) throws IOException, SQLException, ClassNotFoundException {
                boolean b=addstock();
                if(b){
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getClassLoader().getResource("fxml/Stock1.fxml"));
                        Stage stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
                        BorderPane pane = loader.load();
                        stage.getScene().setRoot(pane);
                        stage.show();
                }
                else if(add_product_id.getText().isBlank() || add_product_name.getText().isBlank() || add_price.getText().isBlank() || add_quantity.getText().isBlank()){
                        warninglabel.setText("Invalid details !");
                }
                else{
                        warninglabel.setText("Invalid details !");
                }
        }

        @FXML
        void cancelnow(MouseEvent event) throws IOException {
                JumpScene.changeScene(add_stock_product,"fxml/Stock1.fxml",event);
        }
        public boolean addstock() throws SQLException, ClassNotFoundException {
                int id=Integer.parseInt(add_product_id.getText());
                String pname=add_product_name.getText();
                int price=Integer.parseInt(add_price.getText());
                int stock=Integer.parseInt(add_quantity.getText());
                return Products.createNewProduct(id, pname, price, stock);
        }
    }

