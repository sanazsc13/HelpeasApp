module app.helpeas {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;

    opens app.helpeas to javafx.fxml;
    exports app.helpeas;
    exports app.helpeas.Controller;
    opens app.helpeas.Controller to javafx.fxml;
    opens app.View to javafx.fxml;
}