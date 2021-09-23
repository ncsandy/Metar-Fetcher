module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires jersey.client;
    requires java.ws.rs;
    requires log4j;


    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
}