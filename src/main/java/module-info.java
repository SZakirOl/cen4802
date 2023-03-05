module com.example.mod5ass {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mod5ass to javafx.fxml;
    exports com.example.mod5ass;
}