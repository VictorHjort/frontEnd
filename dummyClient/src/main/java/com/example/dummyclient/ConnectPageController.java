package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ConnectPageController implements Serializable {

    public static Socket socket;
    public boolean isHost;

    @FXML
    private Button connectButton;

    @FXML
    private TextField ipField, portField;


    @FXML
    private void connectButtonPressed(ActionEvent e) throws IOException {
        String ipText = ipField.getText(); //The IP from the user input text field
        int portText = Integer.parseInt(portField.getText()); //The port from the user input text field
        joinServer(ipText, portText); //we join the server with ip address, and port (The port is typecast/changed to an integer by using parseInt.


        Stage stage = (Stage) connectButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("inputName.fxml"));
        Scene connectScene = new Scene(fxmlLoader.load(), 1080, 600);

        //Creating controller object of input name scene
        InputNameController inputNameController = fxmlLoader.getController();
        inputNameController.setSocket(socket);
        inputNameController.setHost(isHost);

        stage.setScene(connectScene);
        stage.show();
    }

    private void joinServer(String ipText, int portText) throws IOException {
        socket = new Socket(ipText, portText);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        isHost = input.readBoolean();
        System.out.println(isHost);
    }


}
