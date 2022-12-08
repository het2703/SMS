package UI.Elements;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmBox {

    static boolean answer;

    public static boolean displayAlert(String alertTitle, String alertMessage){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(alertTitle);
        window.setMinHeight(250);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText(alertMessage);

        //create two buttons

        Button yesButton = new Button("yes");
        Button noButton = new Button ("no");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, yesButton, noButton);

        Scene scene = new Scene(layout, 250, 250);

        window.setScene(scene);
        window.showAndWait();

        return answer;


    }
}