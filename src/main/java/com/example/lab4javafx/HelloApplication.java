package com.example.lab4javafx;

import com.example.lab4javafx.domain.User;
import com.example.lab4javafx.repository.Repository;
import com.example.lab4javafx.repository.dbrepo.UtilizatorDbRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Social Network!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        String username = "postgres";
        String parola = "admin";
        String url ="jdbc:postgresql://localhost:5432/socialnetwork";
        UtilizatorDbRepository repository = UtilizatorDbRepository.getInstance();
        for(User user:repository.findAll()){
            System.out.println(user);
            System.out.println("/n");
        }

    }
}