package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WinWindow {
    @FXML
    private Label text;

    void setText(String text) {
        this.text.setText(text);
    }
}
