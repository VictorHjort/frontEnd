package com.example.dummyclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InputTask implements Runnable {

    public DataInputStream input;

    InputTask(DataInputStream dataInputStream) throws IOException {
        input = dataInputStream;
    }

    public boolean playerJoined () throws IOException {
        return input.readBoolean();
    }

    @Override
    public void run() {

    }
}
