package com.university.modules.week06;
import javafx.fxml.FXML;import javafx.scene.control.Label;import javafx.scene.control.PasswordField;import javafx.scene.control.TextField;
/** Controller for the Week 6 FXML login-form exercise; demo only, no real authentication. */
public class LoginController {@FXML private TextField email;@FXML private PasswordField password;@FXML private Label message;@FXML private void signIn(){if(email.getText().isBlank()||password.getText().isBlank())message.setText("Enter both email and password.");else message.setText("Form submitted (demo only). No credentials were sent.");}}
