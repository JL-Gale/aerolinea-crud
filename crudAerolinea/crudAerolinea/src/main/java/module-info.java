module com.test.crudaerolinea {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;


    opens com.test.logica to javafx.fxml;
    exports com.test.logica;
    exports com.test.igu;
    opens com.test.igu to javafx.fxml;
}