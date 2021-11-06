package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import static javafx.scene.control.Alert.AlertType.WARNING;

public class ShowQuestionController {
    public int alert = 0;
    public Socket socket;
    public String question;
    public DataInputStream inputStream;
    @FXML
    private Button showQuestionButton;

    @FXML
    private void showQuestionButtonPressed(ActionEvent e) throws IOException {

        if (alert == 0) {
            Alert notFull = new Alert(WARNING, "Please make sure everyone host has picked an answer, everything will crash :((");
            notFull.show();
            alert ++;
        }
        else {
            Stage stage = (Stage) showQuestionButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionAndAnswer.fxml"));
            Scene questionAndAnser = new Scene(fxmlLoader.load(), 1080, 600);

            inputStream = new DataInputStream(socket.getInputStream());
            question = inputStream.readUTF();
            //Creating controller object of input name scene and setting label equal
            QuestionAndAnswer questionAndAnswerController = fxmlLoader.getController();
            questionAndAnswerController.displayQuestionTitle(question, "Hvad mon svaret er", false);

            //Setting scene
            stage.setScene(questionAndAnser);
            stage.show();
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
