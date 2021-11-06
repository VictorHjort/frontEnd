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
import java.net.Socket;

public class QuestionBoardController {
    public Socket socket;
    public DataOutputStream outputStream;
    public DataInputStream inputStream;
    public String question, answer;
    public boolean isHost;

    @FXML
    Label boardNameOne, boardNameTwo, boardNameThree;
    @FXML
    Button cat1_100, cat1_200, cat1_300, cat1_400, cat1_500;

    @FXML
    private void questionOneButtonPressed(ActionEvent e) throws IOException{
        Stage stage = (Stage) cat1_100.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionAndAnswer.fxml"));
        Scene questionAndAnswer = new Scene(fxmlLoader.load(), 1080, 600);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.writeInt(1);
        question = inputStream.readUTF();
        answer = inputStream.readUTF();
        QuestionAndAnswer questionAndAnswerController = fxmlLoader.getController();
        questionAndAnswerController.displayQuestionTitle(question,answer,isHost);
        questionAndAnswerController.setHost(isHost);
        stage.setScene(questionAndAnswer);
        stage.show();
    }
    @FXML
    private void questionTwoButtonPressed(ActionEvent e) throws IOException{
        Stage stage = (Stage) cat1_200.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionAndAnswer.fxml"));
        Scene questionAndAnswer = new Scene(fxmlLoader.load(), 1080, 600);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.writeInt(2);
        question = inputStream.readUTF();
        answer = inputStream.readUTF();
        QuestionAndAnswer questionAndAnswerController = fxmlLoader.getController();
        questionAndAnswerController.displayQuestionTitle(question,answer,isHost);
        questionAndAnswerController.setHost(isHost);
        stage.setScene(questionAndAnswer);
        stage.show();
    }
    @FXML
    private void questionThreeButtonPressed(ActionEvent e) throws IOException{
        Stage stage = (Stage) cat1_300.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionAndAnswer.fxml"));
        Scene questionAndAnswer = new Scene(fxmlLoader.load(), 1080, 600);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.writeInt(3);
        question = inputStream.readUTF();
        answer = inputStream.readUTF();
        QuestionAndAnswer questionAndAnswerController = fxmlLoader.getController();
        questionAndAnswerController.displayQuestionTitle(question,answer,isHost);
        questionAndAnswerController.setHost(isHost);
        stage.setScene(questionAndAnswer);
        stage.show();
    }
    @FXML
    private void questionFourButtonPressed(ActionEvent e) throws IOException{
        Stage stage = (Stage) cat1_400.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionAndAnswer.fxml"));
        Scene questionAndAnswer = new Scene(fxmlLoader.load(), 1080, 600);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.writeInt(4);
        question = inputStream.readUTF();
        answer = inputStream.readUTF();
        QuestionAndAnswer questionAndAnswerController = fxmlLoader.getController();
        questionAndAnswerController.displayQuestionTitle(question,answer,isHost);
        questionAndAnswerController.setHost(isHost);
        stage.setScene(questionAndAnswer);
        stage.show();
    }
    @FXML
    private void questionFiveButtonPressed(ActionEvent e) throws IOException{
        Stage stage = (Stage) cat1_500.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("questionAndAnswer.fxml"));
        Scene questionAndAnswer = new Scene(fxmlLoader.load(), 1080, 600);
        outputStream = new DataOutputStream(socket.getOutputStream());
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream.writeInt(5);
        question = inputStream.readUTF();
        answer = inputStream.readUTF();
        QuestionAndAnswer questionAndAnswerController = fxmlLoader.getController();
        questionAndAnswerController.displayQuestionTitle(question,answer,isHost);
        questionAndAnswerController.setHost(isHost);
        stage.setScene(questionAndAnswer);
        stage.show();
    }


    public void setSocket(Socket socket){this.socket = socket;}
    public void setHost(boolean isHost){this.isHost = isHost;}


    public void setPlayeName(int boardNumber, String name) {

        if (boardNumber == 0){
            boardNameOne.setText(name);
        }

        if (boardNumber == 1){
            boardNameTwo.setText(name);
        }

        if (boardNumber == 2){
            boardNameThree.setText(name);
        }
    }
}
