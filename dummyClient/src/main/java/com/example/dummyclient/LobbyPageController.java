package com.example.dummyclient;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LobbyPageController implements Initializable {

    @FXML
    private Label playerOneName;



    public void setHostName(String name){
        playerOneName.setText(name);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
