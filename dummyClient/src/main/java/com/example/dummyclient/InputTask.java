package com.example.dummyclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InputTask implements Runnable{
    public Socket socket;
    public DataInputStream inputStream;
    public int questionNumber = 0;


    InputTask(Socket socket){
        this.socket = socket;
        try {
            inputStream = new DataInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getQuestionNumber() throws IOException{
        return questionNumber;
    }

    public void setQuestionNumber() throws IOException {
       questionNumber = inputStream.readInt();
    }


    @Override
    public void run() {

    }
}
