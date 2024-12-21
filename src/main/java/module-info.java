

module com.mycompany.cafeshopmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.mycompany.cafeshopmanagementsystem to javafx.fxml;
    exports com.mycompany.cafeshopmanagementsystem;
}
