package com.example.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Alert alert;

    @FXML
    private TextField textField;

    @FXML
    protected void onAlertButtonClick() {

        alert = new Alert(Alert.AlertType.INFORMATION);

        if (filterIaco(textField.getText())) {
            JerseyClient jerseyClient = new JerseyClient();
            alert.setTitle("Metar for " + textField.getText());
            alert.setContentText(jerseyClient.metar(textField.getText()));
        }
        else {
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Error in airport format, try again.");
            alert.setTitle("Failed!");
        }
        textField.clear();
        alert.show();
    }

    public boolean filterIaco (String iaco) {
        if (iaco == null || iaco.equals("")) {
            return false;
        }
        return iaco.length() == 4;
    }
}
