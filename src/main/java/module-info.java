module main.sms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens main to javafx.fxml;
    opens UI.Controller to javafx.fxml;
    exports UI.Controller;
}