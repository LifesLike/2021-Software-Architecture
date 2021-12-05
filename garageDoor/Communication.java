package FinalProject.garageDoor;

import FinalProject.broker.JsonMessage;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Communication implements Runnable {
    private String ip = "localhost";
    private Socket socket;
    private int PORT;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    private DoorController doorController;
    Gson gson = new Gson();
    JsonMessage message;
    Thread thread;

    public Communication(DoorController doorController) {
        this(40000, doorController);
    }

    public Communication(int PORT, DoorController doorController) {
        this.PORT = PORT;
        this.doorController = doorController;
    }

    public void connectServer() {
        try {
            socket = new Socket(ip, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            thread = new Thread(this);
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String msg;
        boolean status = true;

        while (status) {
            try {
                msg = in.readLine();
                message = gson.fromJson(msg, JsonMessage.class);

                if (message.getData().equals("open")) {
                    doorController.doorOpen();
                }

            } catch (IOException e) {

            }

        }
    }
}
