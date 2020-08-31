package com.test.controller;

import com.test.EmailManager;
import com.test.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginWindowControler  extends BaseController {

    @FXML
    private Button errorLabel;

    @FXML
    private TextField emailField;

    @FXML
    private TextField PasswordField;

    public LoginWindowControler(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        System.out.println("Click");

    }
}