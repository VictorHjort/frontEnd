package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class InputNameController implements Initializable {

    public Socket socket;
    public DataOutputStream dataOutputStream;

    @FXML
    private Button submitButton;

    @FXML
    private TextField nameField;

    @FXML
    private void submitButtonPressed(ActionEvent e) throws IOException {
        Stage stage = (Stage) submitButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("lobbyPage.fxml"));
        Scene connectScene = new Scene(fxmlLoader.load(), 1080, 600);

        //Creating controller object of input name scene
        LobbyPageController lobbyPageController = fxmlLoader.getController();
        lobbyPageController.setHostName(nameField.getText());

        //Setting scene
        stage.setScene(connectScene);
        stage.show();
        System.out.println(socket);
        sendNameInput();
    }

    public void setSocket(Socket socket){
        this.socket = socket;
    }

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
