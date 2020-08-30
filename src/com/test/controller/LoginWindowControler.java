package com.test.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginWindowControler {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField emailField;

    @FXML
    private TextField PasswordField;

    @FXML
    void loginButtonAction(ActionEvent event) {
        System.out.println("Click");

    }
}