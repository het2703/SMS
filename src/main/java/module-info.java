module main.sms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens main to javafx.fxml;
    opens main.Controller to javafx.fxml;
    exports main;
    exports main.Controller;
}