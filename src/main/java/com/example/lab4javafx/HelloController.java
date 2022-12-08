package com.example.lab4javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    private Button loginButton;
    @FXML
    protected void loginButton() {
        loginButton.setText("hakunamatata");
    }
}