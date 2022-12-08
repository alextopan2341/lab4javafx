package com.example.lab4javafx.controllers;

import com.example.lab4javafx.domain.User;
import com.example.lab4javafx.service.ServiceUser;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class CreateAccount {
    public Label eroare;

    private String Nume;
    private String Prenume;
    private String Email;
    private String Parola;
    private Integer ID;

    @FXML
    private TextField nume;

    @FXML
    private TextField prenume;

    @FXML
    private TextField email;

    @FXML
    private PasswordField parola;

    @FXML
    protected void createAccount() {
        try {
            ID = ServiceUser.getInstance().getId() + 1;
            Nume = nume.getText();
            Prenume = prenume.getText();
            Email = email.getText();
            Parola = parola.getText();
            ServiceUser.getInstance().addElem(new User(ID, Nume, Prenume, Email, Parola));
            System.out.println("Account created succesfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

