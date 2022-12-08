module com.example.lab4javafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.lab4javafx to javafx.fxml;
    exports com.example.lab4javafx;
    exports com.example.lab4javafx.controllers;
    opens com.example.lab4javafx.controllers to javafx.fxml;
}