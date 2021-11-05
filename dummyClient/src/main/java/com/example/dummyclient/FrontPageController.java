package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontPageController {
    @FXML
    private Button joinButton;

    @FXML
    private void joinButtonPressed(ActionEvent e) throws IOException{
        Stage stage = (Stage) joinButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("ConnectPage.fxml"));
        Scene connectScene = new Scene(fxmlLoader.load(), 1080, 600);
        stage.setScene(connectScene);
        stage.show();
    }

    public void printSout() {
        System.out.println("yehhaa");
    }

}
