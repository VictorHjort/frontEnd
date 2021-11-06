package com.example.dummyclient;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class QuestionPageController {

    @FXML
    private Label questionLabel, answer;

    public void displayQuestionTitle(String question, String answer) {
        questionLabel.setText(question);

    }
}
