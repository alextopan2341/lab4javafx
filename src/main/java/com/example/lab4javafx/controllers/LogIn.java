package com.example.lab4javafx.controllers;

import com.example.lab4javafx.HelloApplication;
import com.example.lab4javafx.domain.User;
import com.example.lab4javafx.service.ServiceUser;
import com.example.lab4javafx.controllers.CreateAccount;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.Objects;

public class LogIn {
    private String Email;

    private String Parola;
    ServiceUser serviceUser;

    @FXML
    private Button LogIn;

    @FXML
    private Label eroare;

    @FXML
    private TextField email;

    @FXML
    private PasswordField parola;

    public void login(){
        try {
            Email= email.getText();
            Parola = parola.getText();
            for(User user: serviceUser.getAll()){
                if(Objects.equals(user.getEmail(), Email) && Objects.equals(user.getParola(), Parola)){
                    System.out.println("Login successfully!");
                }
            }
        }
        catch(Exception e){
            eroare.setText("This account doesn't exist! Create one!");
        }
    }

    @FXML
    public void onClickCreateAccount(){
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("createAccount.fxml"));
            Scene scene1 = new Scene(fxmlLoader1.load());
            Stage stage = new Stage();
            stage.setScene(scene1);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
