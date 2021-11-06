package com.example.dummyclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.control.Alert.AlertType.WARNING;

public class LobbyPageHostFirstController implements Initializable {

    public Socket socket;
    public DataInputStream dataInputStream;
    public boolean lobbyFilled, isHost;
    public int alert = 0, questionNumber;
    public String playerName;
    InputTask inputTask;

    @FXML
    private Label playerOneName, playerTwoName, playerThreeName;

    @FXML
    private Button startButton;

    @FXML
    private void startButtonPressed(ActionEvent e) throws IOException {
        dataInputStream = new DataInputStream(socket.getInputStream());
        System.out.println(dataInputStream + " yeah " + socket);

        if (alert == 0) {
            Alert notFull = new Alert(WARNING, "Please make sure everyone have joined! If you press start before, everything will crash :((");
            notFull.show();
            alert ++;
        }
        //>Happens for host
        else if (isHost) {
            Stage stage = (Stage) startButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionBoard.fxml"));
            Scene questionBoard = new Scene(fxmlLoader.load(), 1080, 600);

            //Creating controller object of QuestionBoard name scene
            QuestionBoardController questionBoardController = fxmlLoader.getController();
            questionBoardController.setSocket(socket);
            questionBoardController.setHost(isHost);
            //> reads player names from server
            for (int i = 0; i < 3; i++) {
                playerName = dataInputStream.readUTF();
                questionBoardController.setPlayeName(i, playerName);
            }

            stage.setScene(questionBoard);
            stage.show();
        }
        //>Happens for not host

        else {
            Stage stage = (Stage) startButton.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("showQuestion.fxml"));
            Scene showQuestionButtonScene = new Scene(fxmlLoader.load(), 1080, 600);

            //Creating controller object of QuestionBoard name scene
            ShowQuestionController showQuestionController = fxmlLoader.getController();

            showQuestionController.setSocket(socket);
            stage.setScene(showQuestionButtonScene);
            stage.show();
        }

    }



    public void setHostName(String name){
        playerOneName.setText(name);
    }
    public void setPlayerTwoName(String name) {playerTwoName.setText(name);}
    public void setPlayerThreeName(String name) {playerThreeName.setText(name);}
    public void setSocket(Socket socket) {this.socket=socket;}
    public void setIsHost(boolean isHost) {this.isHost = isHost;}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
