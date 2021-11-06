package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class InputNameController implements Initializable {

    public Socket socket;
    public DataOutputStream dataOutputStream;
    public DataInputStream dataInputStream;
    public boolean isHost;

    @FXML
    private Button submitButton;

    @FXML
    private TextField nameField;

    @FXML
    private void submitButtonPressed(ActionEvent e) throws IOException {
        Stage stage = (Stage) submitButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("lobbyPageHostFirst.fxml"));
        Scene lobbyPage = new Scene(fxmlLoader.load(), 1080, 600);

        //Creating controller object of input name scene and setting label equal
        LobbyPageHostFirstController lobbyPageHostFirstController = fxmlLoader.getController();
        lobbyPageHostFirstController.setHostName(nameField.getText());
        lobbyPageHostFirstController.setSocket(socket);
        lobbyPageHostFirstController.setIsHost(isHost);

        //Setting scene
        stage.setScene(lobbyPage);
        stage.show();
        sendNameInput();

    }

    public void setSocket(Socket socket){
        this.socket = socket;
    }

    public void setHost(Boolean isHost){this.isHost = isHost;}

    public void sendNameInput() throws IOException
    {
        System.out.println("Socket:" + socket);
        System.out.println("Name:" + nameField.getText());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(nameField.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
