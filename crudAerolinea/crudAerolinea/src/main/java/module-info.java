module com.test.crudaerolinea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.test.crudaerolinea to javafx.fxml;
    exports com.test.crudaerolinea;
}