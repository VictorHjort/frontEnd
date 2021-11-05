package com.example.dummyclient;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class QuestionBoardController {
    @FXML
    Label boardNameOne, boardNameTwo, boardNameThree;

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
