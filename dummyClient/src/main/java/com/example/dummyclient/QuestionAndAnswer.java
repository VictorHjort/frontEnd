package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class QuestionAndAnswer {

    public boolean isHost;

    @FXML
    private Label questionLabel, answerLabel;
    @FXML
    private Button doneButton;

    @FXML
    private void doneButtonPressed(ActionEvent e) throws IOException {
        if(isHost) {
            Stage stage = (Stage) doneButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionBoard.fxml"));
            Scene questionBoard = new Scene(fxmlLoader.load(), 1080, 600);
            stage.setScene(questionBoard);
            stage.show();
        }
        else {
            Stage stage = (Stage) doneButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("showQuestion.fxml"));
            Scene showQuestion = new Scene(fxmlLoader.load(), 1080, 600);
            stage.setScene(showQuestion);
            stage.show();
        }
    }

    public void setHost(boolean isHost){this.isHost=isHost;}

    public void displayQuestionTitle(String question, String answer, boolean isHost) {
        questionLabel.setText(question);

        if (isHost){
            answerLabel.setText(answer);
        }

    }



}
