package com.example.dummyclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JeopartyApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JeopartyApplication.class.getResource("frontPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 600);
        stage.setTitle("JeoParty!");
        stage.setScene(scene);
        stage.show();
        //Getting controller class
        FrontPageController ctrl = fxmlLoader.getController();
    }

    //The main function which starts an instance of the JavaFX application
    public static void main(String[] args) {
        launch();
    }
}